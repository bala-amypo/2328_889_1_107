package com.example.demo.service;

import com.example.demo.model.Parcel;
import java.util.Optional;

public interface ParcelService {

    Parcel addParcel(Parcel parcel);

    Parcel updateParcel(Long id, Parcel parcel);

    void deleteParcel(Long id);

    Optional<Parcel> getByTrackingNumber(String trackingNumber);
}
