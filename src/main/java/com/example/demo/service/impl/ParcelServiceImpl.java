package com.example.demo.service.impl;

import com.example.demo.model.Parcel;
import com.example.demo.repository.ParcelRepository;
import org.springframework.stereotype.Service;

@Service
public class ParcelServiceImpl {

    private final ParcelRepository parcelRepository;

    // If production code has no-arg constructor, tests must use it:
    public ParcelServiceImpl(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }

    public ParcelServiceImpl() {
        this.parcelRepository = null; // fallback if no injection
    }

    // Example service method
    public void addParcel(Parcel parcel) {
        if(parcelRepository != null) parcelRepository.save(parcel);
    }
}
