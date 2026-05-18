package com.example.spring_auth_demo.service;

import com.example.spring_auth_demo.dto.LoginRequest;
import com.example.spring_auth_demo.dto.RegisterRequest;
import com.example.spring_auth_demo.entity.User;
import com.example.spring_auth_demo.exception.InvalidCredentialsException;
import com.example.spring_auth_demo.exception.UserAlreadyExistsException;
import com.example.spring_auth_demo.repository.UserRepository;
import com.example.spring_auth_demo.service.AuthService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public String register(RegisterRequest request) {
        if(userRepository.existsByEmail(request.getEmail())){
            throw new UserAlreadyExistsException("Email already registered");
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(user);

        return "User registered successfully...";
    }

    @Override
    public String login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new InvalidCredentialsException(
                                "Invalid email or password"
                        ));

        boolean matches = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if(!matches){
            throw new InvalidCredentialsException("Invalid email or password");
        }
        return "Login Successfully..";
    }
}
