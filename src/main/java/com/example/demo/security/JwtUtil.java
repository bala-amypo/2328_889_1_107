package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {
    
    private final String secretKey;
    private final long expirationMillis;
    private final SecretKey key;
    
    public JwtUtil() {
        this.secretKey = "mySecretKeyForJWTTokenGenerationThatIsLongEnough";
        this.expirationMillis = 86400000; // 24 hours
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }
    
    public JwtUtil(String secretKey, long expirationMillis) {
        this.secretKey = secretKey;
        this.expirationMillis = expirationMillis;
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }
    
    public String generateToken(Long userId, String email, String role) {
        return Jwts.builder()
            .claim("userId", userId)
            .claim("email", email)
            .claim("role", role)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
            .signWith(key)
            .compact();
    }
    
    public Claims validateToken(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .getBody();
    }
}