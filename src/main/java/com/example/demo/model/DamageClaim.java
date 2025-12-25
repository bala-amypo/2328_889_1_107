package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

@Entity
@Table(name = "damage_claims")
public class DamageClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parcel_id")
    private Parcel parcel;

    private String claimDescription;

    private LocalDateTime filedAt;

    private String status = "PENDING";

    private Double score;

    @ManyToMany
    @JoinTable(
        name = "claim_applied_rules",
        joinColumns = @JoinColumn(name = "claim_id"),
        inverseJoinColumns = @JoinColumn(name = "rule_id")
    )
    private Set<ClaimRule> appliedRules = new HashSet<>();

    @OneToMany(mappedBy = "claim")
    private List<Evidence> evidences;

    public DamageClaim() {}

    @PrePersist
    public void prePersist() {
        if (filedAt == null) filedAt = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Parcel getParcel() { return parcel; }
    public void setParcel(Parcel parcel) { this.parcel = parcel; }

    public String getClaimDescription() { return claimDescription; }
    public void setClaimDescription(String claimDescription) { this.claimDescription = claimDescription; }

    public LocalDateTime getFiledAt() { return filedAt; }
    public void setFiledAt(LocalDateTime filedAt) { this.filedAt = filedAt; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    public Set<ClaimRule> getAppliedRules() { return appliedRules; }
    public void setAppliedRules(Set<ClaimRule> appliedRules) { this.appliedRules = appliedRules; }

    public List<Evidence> getEvidences() { return evidences; }
    public void setEvidences(List<Evidence> evidences) { this.evidences = evidences; }
}
