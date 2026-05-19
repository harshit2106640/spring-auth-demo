package com.example.spring_auth_demo.service;

import com.example.spring_auth_demo.dto.ApiResponse;
import com.example.spring_auth_demo.dto.LoginRequest;
import com.example.spring_auth_demo.dto.LoginResponse;
import com.example.spring_auth_demo.dto.RegisterRequest;
import com.example.spring_auth_demo.entity.User;
import com.example.spring_auth_demo.exception.InvalidCredentialsException;
import com.example.spring_auth_demo.exception.UserAlreadyExistsException;
import com.example.spring_auth_demo.repository.UserRepository;

import com.example.spring_auth_demo.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public ApiResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException(
                    "Email already registered"
            );
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role("USER")
                .build();

        userRepository.save(user);

        return new ApiResponse(
                true,
                "User registered successfully"
        );
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new InvalidCredentialsException(
                                "Invalid email or password"
                        ));

        boolean matches = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if (!matches) {
            throw new InvalidCredentialsException(
                    "Invalid email or password"
            );
        }

        String token = jwtService.generateToken(user.getEmail());

        return new LoginResponse(
                true,
                "Login successful",
                token
        );
    }
}