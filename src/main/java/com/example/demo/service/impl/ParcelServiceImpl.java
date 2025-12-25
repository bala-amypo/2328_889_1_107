package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
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
    public Parcel createParcel(Parcel parcel) {
        if (parcelRepository.existsByTrackingNumber(parcel.getTrackingNumber())) {
            throw new BadRequestException("Parcel with tracking number already exists");
        }
        return parcelRepository.save(parcel);
    }

    @Override
    public Parcel getParcelById(Long id) {
        return parcelRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Parcel not found with id " + id));
    }

    @Override
    public List<Parcel> getAllParcels() {
        return parcelRepository.findAll();
    }

    @Override
    public Parcel updateParcel(Long id, Parcel parcel) {
        Parcel existing = parcelRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Parcel not found with id " + id));

        existing.setWeightKg(parcel.getWeightKg());
        existing.setSenderName(parcel.getSenderName());
        existing.setReceiverName(parcel.getReceiverName());
        existing.setDeliveredAt(parcel.getDeliveredAt());

        return parcelRepository.save(existing);
    }

    @Override
    public void deleteParcel(Long id) {
        Parcel existing = parcelRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Parcel not found with id " + id));
        parcelRepository.delete(existing);
    }

    @Override
    public boolean existsByTrackingNumber(String trackingNumber) {
        return parcelRepository.existsByTrackingNumber(trackingNumber);
    }

    @Override
    public Parcel findByTrackingNumber(String trackingNumber) {
        return parcelRepository.findByTrackingNumber(trackingNumber)
                .orElseThrow(() -> new BadRequestException("Parcel not found with tracking number " + trackingNumber));
    }
}
