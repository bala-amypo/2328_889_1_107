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
    private String fileUrl;
    private LocalDateTime uploadedAt;

    @ManyToOne
    @JoinColumn(name = "claim_id") // Keeps DB structure correct
    private DamageClaim damageClaim; // Matches the Service "setDamageClaim"

    public Evidence() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }
    public String getFileUrl() { return fileUrl; }
    public void setFileUrl(String fileUrl) { this.fileUrl = fileUrl; }
    public LocalDateTime getUploadedAt() { return uploadedAt; }
    public void setUploadedAt(LocalDateTime uploadedAt) { this.uploadedAt = uploadedAt; }
    
    // This fixed the Service error: method setDamageClaim
    public DamageClaim getDamageClaim() { return damageClaim; }
    public void setDamageClaim(DamageClaim damageClaim) { this.damageClaim = damageClaim; }
}