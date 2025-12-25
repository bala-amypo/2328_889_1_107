package com.example.demo.service;

import com.example.demo.model.Parcel;
import java.util.List;

public interface ParcelService {

    Parcel addParcel(Parcel parcel);

    Parcel getParcelById(Long id);

    Parcel getByTrackingNumber(String trackingNumber);

    List<Parcel> getAllParcels();

    Parcel updateParcel(Long id, Parcel parcel);

    void deleteParcel(Long id);
}
