package com.example.demo.model;
import jakarta.persistence.Id;
import java.time.LocalDate;

public class Parcel{
    @Id
    private Long id;
    @Column(unique = true)
    private String trackingNumber;
    private String senderName;
    private String receiverName;
    private double weightKg;
    private LocalDate deliveredAt;
}