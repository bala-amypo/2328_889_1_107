package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Parcel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String senderName;
    private String receiverName;
    private String trackingNumber;
    private double weightKg;
    private LocalDateTime deliveredAt;

    // Default constructor
    public Parcel() {}

    // Parameterized constructor for tests
    public Parcel(String senderName, String receiverName, String trackingNumber, double weightKg) {
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.trackingNumber = trackingNumber;
        this.weightKg = weightKg;
    }

    // Getters and setters used in tests
    public String getSenderName() { return senderName; }
    public void setSenderName(String senderName) { this.senderName = senderName; }

    public String getReceiverName() { return receiverName; }
    public void setReceiverName(String receiverName) { this.receiverName = receiverName; }

    public String getTrackingNumber() { return trackingNumber; }
    public void setTrackingNumber(String trackingNumber) { this.trackingNumber = trackingNumber; }

    public double getWeightKg() { return weightKg; }
    public void setWeightKg(double weightKg) { this.weightKg = weightKg; }

    public LocalDateTime getDeliveredAt() { return deliveredAt; }
    public void setDeliveredAt(LocalDateTime deliveredAt) { this.deliveredAt = deliveredAt; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
