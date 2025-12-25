package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class DamageClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String claimDescription;

    @OneToMany(mappedBy = "damageClaim", cascade = CascadeType.ALL)
    private List<Evidence> evidences;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getClaimDescription() { return claimDescription; }
    public void setClaimDescription(String claimDescription) { this.claimDescription = claimDescription; }

    public List<Evidence> getEvidences() { return evidences; }
    public void setEvidences(List<Evidence> evidences) { this.evidences = evidences; }
}
