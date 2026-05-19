package com.example.spring_auth_demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/api/admin/dashboard")
    public String adminDashboard() {

        return "Admin dashboard accessed";
    }
}
