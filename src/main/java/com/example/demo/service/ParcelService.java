package com.example.demo.service;

import com.example.demo.model.Parcel;
import java.util.List;
import java.util.Optional;

public interface ParcelService {
    Parcel createParcel(Parcel parcel);
    List<Parcel> getAllParcels();
    Optional<Parcel> getParcelById(Long id);
    Parcel updateParcel(Long id, Parcel parcel);
    void deleteParcel(Long id);
}
