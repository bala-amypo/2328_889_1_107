package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class ClaimRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // This is the internal name
    private String description;
    private String conditionExpression;
    private double weight;

    public ClaimRule() {}

    // REQUIRED: Fixes "no suitable constructor found" errors (lines 199, 206, 213, etc.)
    public ClaimRule(String name, String description, String conditionExpression, double weight) {
        this.name = name;
        this.description = description;
        this.conditionExpression = conditionExpression;
        this.weight = weight;
    }

    // REQUIRED: Test suite calls getRuleName/setRuleName (lines 388, 694, 695)
    public String getRuleName() { return name; }
    public void setRuleName(String name) { this.name = name; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getConditionExpression() { return conditionExpression; }
    public void setConditionExpression(String conditionExpression) { this.conditionExpression = conditionExpression; }
    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }
}