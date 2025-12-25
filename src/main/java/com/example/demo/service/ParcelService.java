package com.example.demo.service;

import com.example.demo.model.Parcel;

import java.util.List;

public interface ParcelService {

    Parcel createParcel(Parcel parcel);

    Parcel getParcelById(Long id);

    List<Parcel> getAllParcels();

    Parcel updateParcel(Long id, Parcel parcel);

    void deleteParcel(Long id);

    boolean existsByTrackingNumber(String trackingNumber);

    Parcel findByTrackingNumber(String trackingNumber);
}
