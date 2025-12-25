package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException; // Use your existing exception
import com.example.demo.model.Parcel;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.service.ParcelService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParcelServiceImpl implements ParcelService {

    private final ParcelRepository parcelRepository;

    // REQUIRED: Fixes Test Suite error on line 38 (constructor ParcelServiceImpl)
    public ParcelServiceImpl(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }

    @Override
    public Parcel addParcel(Parcel parcel) {
        return parcelRepository.save(parcel);
    }

    @Override
    // REQUIRED: Fixes Test Suite error on line 144 (incompatible types: Optional vs Parcel)
    public Parcel getByTrackingNumber(String trackingNumber) {
        return parcelRepository.findByTrackingNumber(trackingNumber)
                .orElseThrow(() -> new BadRequestException("Parcel not found"));
    }

    @Override
    public Parcel updateParcel(Long id, Parcel updatedParcel) {
        Parcel parcel = parcelRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Parcel not found"));

        parcel.setTrackingNumber(updatedParcel.getTrackingNumber());
        parcel.setDescription(updatedParcel.getDescription());
        parcel.setSenderName(updatedParcel.getSenderName()); // Added to match model updates
        parcel.setWeightKg(updatedParcel.getWeightKg());     // Added to match model updates

        return parcelRepository.save(parcel);
    }

    @Override
    public void deleteParcel(Long id) {
        parcelRepository.deleteById(id);
    }
}