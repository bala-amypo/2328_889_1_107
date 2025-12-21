package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Parcel;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.service.ParcelService;

@Service
public class ParcelServiceImpl implements ParcelService {

    @Autowired
    private ParcelRepository parcelRepository;

    @Override
    public Parcel addParcel(Parcel parcel) {

        // double cannot be null → validate against 0
        if (parcel.getWeightKg() == 0) {
            throw new RuntimeException("Parcel weight cannot be zero");
        }

        return parcelRepository.save(parcel);
    }

    @Override
    public Parcel getByTrackingNumber(String trackingNumber) {
        return parcelRepository.findByTrackingNumber(trackingNumber)
                .orElseThrow(() ->
                        new RuntimeException("Parcel not found with tracking number: " + trackingNumber));
    }
}
