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
    public Optional<Parcel> getByTrackingNumber(String trackingNumber) {
        return parcelRepository.findByTrackingNumber(trackingNumber);
    }

    @Override
    public Parcel updateParcel(Long id, Parcel updatedParcel) {
        Parcel parcel = parcelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parcel not found"));

        parcel.setTrackingNumber(updatedParcel.getTrackingNumber());
        parcel.setDescription(updatedParcel.getDescription()); // make sure description exists in Parcel model

        return parcelRepository.save(parcel);
    }

    @Override
    public void deleteParcel(Long id) {
        parcelRepository.deleteById(id);
    }
}
