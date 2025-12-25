package com.example.demo.service;

import com.example.demo.model.Parcel;
import java.util.Optional;

public interface ParcelService {
    Parcel addParcel(Parcel parcel);
    
    // Change return type from Optional<Parcel> to Parcel
    Parcel getByTrackingNumber(String trackingNumber);
    
    Parcel updateParcel(Long id, Parcel updatedParcel);
    void deleteParcel(Long id);
}