package com.example.demo.model;
import jakarta.persistence.*;

@Entity
public class ClaimRule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ruleName;
    private String expression;
    private Double weight;

    public ClaimRule() {}
    public ClaimRule(String ruleName, String expression, Double weight) {
        this.ruleName = ruleName; this.expression = expression; this.weight = weight;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }
    public String getExpression() { return expression; }
    public void setExpression(String expression) { this.expression = expression; }
    public Double getWeight() { return weight; }
    public void setWeight(Double weight) { this.weight = weight; }
}