package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "evidences")
public class Evidence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String fileName;
    
    // REQUIRED: Test suite calls getFileUrl/setFileUrl
    private String fileUrl; 
    
    // REQUIRED: Test suite calls getUploadedAt/setUploadedAt
    private LocalDateTime uploadedAt;

    @ManyToOne
    @JoinColumn(name = "claim_id")
    // REQUIRED: Service uses "damageClaim" naming
    private DamageClaim damageClaim; 

    public Evidence() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getFileUrl() { return fileUrl; }
    public void setFileUrl(String fileUrl) { this.fileUrl = fileUrl; }

    public LocalDateTime getUploadedAt() { return uploadedAt; }
    public void setUploadedAt(LocalDateTime uploadedAt) { this.uploadedAt = uploadedAt; }

    public DamageClaim getDamageClaim() { return damageClaim; }
    public void setDamageClaim(DamageClaim damageClaim) { this.damageClaim = damageClaim; }
}