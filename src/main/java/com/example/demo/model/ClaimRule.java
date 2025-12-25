package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

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
    private Set<DamageClaim> claims = new HashSet<>();

    public ClaimRule() {}

    public ClaimRule(String ruleName, String conditionExpression, Double weight) {
        this.ruleName = ruleName;
        this.conditionExpression = conditionExpression;
        this.weight = weight;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }

    public String getConditionExpression() { return conditionExpression; }
    public void setConditionExpression(String conditionExpression) { this.conditionExpression = conditionExpression; }

    public Double getWeight() { return weight; }
    public void setWeight(Double weight) { this.weight = weight; }

    public Set<DamageClaim> getClaims() { return claims; }
    public void setClaims(Set<DamageClaim> claims) { this.claims = claims; }
}
