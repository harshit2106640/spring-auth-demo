package com.example.spring_auth_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
    private boolean success;

    private String message;

}
