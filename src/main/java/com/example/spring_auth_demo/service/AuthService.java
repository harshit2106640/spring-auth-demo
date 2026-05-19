package com.example.spring_auth_demo.service;

import com.example.spring_auth_demo.dto.ApiResponse;
import com.example.spring_auth_demo.dto.LoginRequest;
import com.example.spring_auth_demo.dto.LoginResponse;
import com.example.spring_auth_demo.dto.RegisterRequest;

public interface AuthService {

    ApiResponse register(RegisterRequest request);
    LoginResponse login(LoginRequest request);
}
