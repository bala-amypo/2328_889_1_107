package com.example.demo.service.impl;

import com.example.demo.model.Parcel;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.service.ParcelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParcelServiceImpl implements ParcelService {

    private final ParcelRepository parcelRepository;

    public ParcelServiceImpl(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }

    // This method name must match ParcelService
    @Override
    public Parcel register(Parcel parcel) {   // <-- use 'register' if interface has 'register'
        return parcelRepository.save(parcel);
    }

    @Override
    public List<Parcel> getAllParcels() {
        return parcelRepository.findAll();
    }

    @Override
    public Parcel getByTrackingNumber(String trackingNumber) {
        Optional<Parcel> parcelOpt = parcelRepository.findByTrackingNumber(trackingNumber);
        return parcelOpt.orElse(null);
    }
}
