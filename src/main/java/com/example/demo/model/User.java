package com.example.demo.model;
import jakarta.persistence.Id;

public class User{
    @Id
    private Long id;
    private String name;
    @Column(unique=true)
    private String email;
    private String password;
    private String ADMIN;
    private String AGENT;
}