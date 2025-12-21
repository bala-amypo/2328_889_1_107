package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        // Dummy implementation to compile
        return new AuthResponse("dummy-token");
    }

    @PostMapping("/register")
    public ApiResponse register(@RequestBody AuthRequest request) {
        return new ApiResponse("User registered successfully");
    }
}
