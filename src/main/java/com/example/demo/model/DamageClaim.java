package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DamageClaim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String claimDescription;
    private String status = "PENDING";
    private Double score;

    @ManyToOne
    private Parcel parcel;

    @ManyToMany
    private List<ClaimRule> appliedRules = new ArrayList<>();
}