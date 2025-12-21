package com.example.demo.service.impl;

import com.example.demo.model.Parcel;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParcelServiceImpl implements ParcelService {

    @Autowired
    private ParcelRepository parcelRepository;

    @Override
    public Parcel createParcel(Parcel parcel) {
        return parcelRepository.save(parcel);
    }

    @Override
    public List<Parcel> getAllParcels() {
        return parcelRepository.findAll();
    }

    @Override
    public Optional<Parcel> getParcelById(Long id) {
        return parcelRepository.findById(id);
    }

    @Override
    public Parcel updateParcel(Long id, Parcel parcel) {
        Parcel existingParcel = parcelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parcel not found"));
        existingParcel.setName(parcel.getName());
        existingParcel.setAddress(parcel.getAddress());
        existingParcel.setStatus(parcel.getStatus());
        return parcelRepository.save(existingParcel);
    }

    @Override
    public void deleteParcel(Long id) {
        parcelRepository.deleteById(id);
    }
}
