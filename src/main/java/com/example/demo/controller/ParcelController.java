package com.example.demo.controller;

import com.example.demo.model.Parcel;
import com.example.demo.service.ParcelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parcels")
public class ParcelController {

    private final ParcelService parcelService;

    public ParcelController(ParcelService parcelService) {
        this.parcelService = parcelService;
    }

    @PostMapping
    public ResponseEntity<Parcel> addParcel(@RequestBody Parcel parcel) {
        return ResponseEntity.ok(parcelService.addParcel(parcel));
    }

    @GetMapping("/tracking/{number}")
    public ResponseEntity<Parcel> getByTracking(@PathVariable String number) {
        // Corrected: getByTrackingNumber now returns Parcel directly
        Parcel parcel = parcelService.getByTrackingNumber(number);
        return ResponseEntity.ok(parcel);
    }
}