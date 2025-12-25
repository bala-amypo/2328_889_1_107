package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "parcels")
public class Parcel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String trackingNumber;
    private String description;
    private String senderName;
    private double weightKg;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Parcel() {}

    public Parcel(String trackingNumber, String description, String senderName, double weightKg) {
        this.trackingNumber = trackingNumber;
        this.description = description;
        this.senderName = senderName;
        this.weightKg = weightKg;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTrackingNumber() { return trackingNumber; }
    public void setTrackingNumber(String trackingNumber) { this.trackingNumber = trackingNumber; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getSenderName() { return senderName; }
    public void setSenderName(String senderName) { this.senderName = senderName; }
    public double getWeightKg() { return weightKg; }
    public void setWeightKg(double weightKg) { this.weightKg = weightKg; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}