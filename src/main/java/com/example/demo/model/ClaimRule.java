package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "claim_rules")
public class ClaimRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;

    private String conditionExpression;

    private Double weight;

    @ManyToMany(mappedBy = "appliedRules")
    private Set<DamageClaim> damageClaims;

    // 🔹 No-arg constructor
    public ClaimRule() {
    }

    // 🔹 Parameterized constructor
    public ClaimRule(String ruleName, String conditionExpression, Double weight) {
        this.ruleName = ruleName;
        this.conditionExpression = conditionExpression;
        this.weight = weight;
    }

    // 🔹 Getters and Setters

    public Long getId() {
        return id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public String getConditionExpression() {
        return conditionExpression;
    }

    public Double getWeight() {
        return weight;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public void setConditionExpression(String conditionExpression) {
        this.conditionExpression = conditionExpression;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Set<DamageClaim> getDamageClaims() {
        return damageClaims;
    }

    public void setDamageClaims(Set<DamageClaim> damageClaims) {
        this.damageClaims = damageClaims;
    }
}
