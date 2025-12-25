package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Parcel;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.service.ParcelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParcelServiceImpl implements ParcelService {

    private final ParcelRepository parcelRepository;

    public ParcelServiceImpl(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }

    @Override
    public Parcel addParcel(Parcel parcel) {

        if (parcelRepository.existsByTrackingNumber(parcel.getTrackingNumber())) {
            throw new BadRequestException("tracking number exists");
        }

        if (parcel.getWeightKg() == null || parcel.getWeightKg() <= 0) {
            throw new BadRequestException("weight must be greater than 0");
        }

        return parcelRepository.save(parcel);
    }

    @Override
    public Parcel getParcelById(Long id) {
        return parcelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Parcel not found"));
    }

    @Override
    public Parcel getByTrackingNumber(String trackingNumber) {
        return parcelRepository.findByTrackingNumber(trackingNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Parcel not found"));
    }

    @Override
    public List<Parcel> getAllParcels() {
        return parcelRepository.findAll();
    }

    @Override
    public Parcel updateParcel(Long id, Parcel parcel) {

        Parcel existing = parcelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Parcel not found"));

        existing.setSenderName(parcel.getSenderName());
        existing.setReceiverName(parcel.getReceiverName());
        existing.setWeightKg(parcel.getWeightKg());
        existing.setDeliveredAt(parcel.getDeliveredAt());

        return parcelRepository.save(existing);
    }

    @Override
    public void deleteParcel(Long id) {

        if (!parcelRepository.existsById(id)) {
            throw new ResourceNotFoundException("Parcel not found");
        }

        parcelRepository.deleteById(id);
    }
}
