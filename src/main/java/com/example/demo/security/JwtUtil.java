package com.example.demo.security;

public class JwtUtil {

    public JwtUtil(String secretKey, long expirationMillis) {}

    public String generateToken(Long userId, String email, String role) {
        return "dummy-token";
    }
}
