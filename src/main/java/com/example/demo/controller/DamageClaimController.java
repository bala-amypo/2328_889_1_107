package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "damage_claims")
public class DamageClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parcel_id", nullable = false)
    private Parcel parcel;

    private String claimDescription;

    private String status = "PENDING";

    private Double score;

    @ManyToMany
    @JoinTable(
        name = "damage_claim_rule",
        joinColumns = @JoinColumn(name = "claim_id"),
        inverseJoinColumns = @JoinColumn(name = "rule_id")
    )
    private Set<ClaimRule> appliedRules = new HashSet<>();

    @PrePersist
    public void prePersist() {
        this.filedAt = LocalDateTime.now();
    }

    private LocalDateTime filedAt;

    public DamageClaim() {}
    // Getters and setters...
}
