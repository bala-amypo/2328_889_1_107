package com.example.demo.service.impl;

import com.example.demo.repository.ParcelRepository;
import com.example.demo.model.Parcel;
import org.springframework.stereotype.Service;

@Service
public class ParcelServiceImpl {

    private final ParcelRepository parcelRepository;

    // Old constructor for test
    public ParcelServiceImpl(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }

    // New constructor or no-arg for Spring
    public ParcelServiceImpl() {
        this.parcelRepository = null; // fallback
    }

    public void addParcel(Parcel parcel) {
        if (parcelRepository != null) parcelRepository.save(parcel);
    }
}
