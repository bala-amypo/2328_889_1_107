package com.example.demo.model;
import java.time.*;

import jakarta.persistence.Id;

public class Evidence{
    @Id
    private Long id;
    private String IMAGE;
    private String DOCUMENT;
    private String TEXT;
    private String fileUrl;
    private LocalDateTime uploadedAt;

}