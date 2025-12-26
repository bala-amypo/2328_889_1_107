package com.example.demo.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DamageClaim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String claimDescription;
    
    // Test 32: Initial status must be PENDING
    private String status = "PENDING";
    
    // Test 49: Initial score must be null
    private Double score;

    @ManyToOne
    private Parcel parcel;

    // Test 36 & 50: Applied rules must be an empty list, NOT null
    @ManyToMany
    private List<ClaimRule> appliedRules = new ArrayList<>();

    public DamageClaim() {}

    // GETTERS AND SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getClaimDescription() { return claimDescription; }
    public void setClaimDescription(String claimDescription) { this.claimDescription = claimDescription; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }
    public Parcel getParcel() { return parcel; }
    public void setParcel(Parcel parcel) { this.parcel = parcel; }
    public List<ClaimRule> getAppliedRules() { return appliedRules; }
    public void setAppliedRules(List<ClaimRule> appliedRules) { this.appliedRules = appliedRules; }
}