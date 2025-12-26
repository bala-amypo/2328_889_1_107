package com.example.demo.service.impl;

import com.example.demo.model.Parcel;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.service.ParcelService;

public class ParcelServiceImpl implements ParcelService {

    private final ParcelRepository repo;

    public ParcelServiceImpl(ParcelRepository repo) {
        this.repo = repo;
    }

    public Parcel addParcel(Parcel parcel) {
        if (repo.existsByTrackingNumber(parcel.getTrackingNumber()))
            throw new RuntimeException("Tracking already exists");
        return repo.save(parcel);
    }

    public Parcel getByTrackingNumber(String tracking) {
        return repo.findByTrackingNumber(tracking)
                .orElseThrow(() -> new RuntimeException("Parcel not found"));
    }
}
