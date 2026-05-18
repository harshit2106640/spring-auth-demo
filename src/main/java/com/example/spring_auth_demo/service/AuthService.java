package com.example.spring_auth_demo.service;

import com.example.spring_auth_demo.dto.LoginRequest;
import com.example.spring_auth_demo.dto.RegisterRequest;

public interface AuthService {

    String register(RegisterRequest request);
    String login(LoginRequest request);
}
