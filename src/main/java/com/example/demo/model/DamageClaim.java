package com.example.demo.model;
import jakarta.persistence.Id;
public class damageClaim{
    @Id
    private Long id;
    private String claimDescription;
    private LocalDateTime filedAt;
    private String PENDING;
    private String APPROVED;
    private String REJECTED;
    private Double score;
    

}