package com.example.demo.model;
import jakarta.persistence.Id;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;

public class Parcel{
    @Id
    private Long id;
    @Column(unique = true)
    private String trackingNumber;
    private String senderName;
    private String receiverName;
    @Min(1)
    private Double weightKg;

    private LocalDateTime deliveredAt;
}