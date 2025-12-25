package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "damage_claims")
public class DamageClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private LocalDateTime filedAt;

    private double score;

    @ManyToOne
    @JoinColumn(name = "parcel_id")
    private Parcel parcel;

    @ManyToMany
    @JoinTable(
        name = "claim_applied_rules",
        joinColumns = @JoinColumn(name = "claim_id"),
        inverseJoinColumns = @JoinColumn(name = "rule_id")
    )
    private Set<ClaimRule> appliedRules;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getFiledAt() { return filedAt; }
    public void setFiledAt(LocalDateTime filedAt) { this.filedAt = filedAt; }

    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }

    public Parcel getParcel() { return parcel; }
    public void setParcel(Parcel parcel) { this.parcel = parcel; }

    public Set<ClaimRule> getAppliedRules() { return appliedRules; }
    public void setAppliedRules(Set<ClaimRule> appliedRules) { this.appliedRules = appliedRules; }
}
