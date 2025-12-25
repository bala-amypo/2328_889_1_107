package com.example.demo.service;

import com.example.demo.model.Parcel;
import java.util.List;

public interface ParcelService {

    Parcel addParcel(Parcel parcel);

    Parcel getByTrackingNumber(String trackingNumber);

    List<Parcel> getAllParcels();

    void deleteParcel(Long id);
}
