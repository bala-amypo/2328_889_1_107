package com.example.demo.service.impl;

import com.example.demo.model.Parcel;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParcelServiceImpl implements ParcelService {

    @Autowired
    private ParcelRepository parcelRepository;

    @Override
    public Parcel addParcel(Parcel parcel) {
        return parcelRepository.save(parcel);
    }

    @Override
    public Parcel updateParcel(Long id, Parcel parcel) {
        Parcel existing = parcelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parcel not found"));
        existing.setTrackingNumber(parcel.getTrackingNumber());
        existing.setDescription(parcel.getDescription());
        return parcelRepository.save(existing);
    }

    @Override
    public void deleteParcel(Long id) {
        parcelRepository.deleteById(id);
    }

    @Override
    public Optional<Parcel> getByTrackingNumber(String trackingNumber) {
        return parcelRepository.findByTrackingNumber(trackingNumber);
    }
}
