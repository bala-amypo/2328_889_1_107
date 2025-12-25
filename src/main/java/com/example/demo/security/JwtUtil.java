package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private final String secretKey = "replace_with_secure_key";
    private final long expirationMillis = 24 * 60 * 60 * 1000; // 24 hours

    public String generateToken(Long userId, String email, String role) {
        return Jwts.builder()
                .claim("userId", userId)
                .claim("email", email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public Claims validateToken(String token) throws JwtException, ExpiredJwtException {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }
}
