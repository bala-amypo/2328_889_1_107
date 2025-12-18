package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class DamageClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Parcel parcel;

    private String claimDescription;
    private LocalDateTime filedAt;
    private String status;
    private Double score;

    @ManyToMany
    private List<ClaimRule> appliedRules;

    public DamageClaim() {}

    @PrePersist
    public void onCreate() {
        this.filedAt = LocalDateTime.now();
        this.status = "PENDING";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Parcel getParcel() {
        return parcel;
    }

    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }

    public String getClaimDescription() {
        return claimDescription;
    }

    public void setClaimDescription(String claimDescription) {
        this.claimDescription = claimDescription;
    }

    public LocalDateTime getFiledAt() {
        return filedAt;
    }

    public void setFiledAt(LocalDateTime filedAt) {
        this.filedAt = filedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public List<ClaimRule> getAppliedRules() {
        return appliedRules;
    }

    public void setAppliedRules(List<ClaimRule> appliedRules) {
        this.appliedRules = appliedRules;
    }
}
