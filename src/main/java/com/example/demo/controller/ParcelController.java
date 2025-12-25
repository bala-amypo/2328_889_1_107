package com.example.demo.controller;

import com.example.demo.model.Parcel;
import com.example.demo.service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parcels")
public class ParcelController {

    @Autowired
    private ParcelService parcelService;

    @PostMapping
    public Parcel addParcel(@RequestBody Parcel parcel) {
        return parcelService.addParcel(parcel);
    }

    @GetMapping("/tracking/{trackingNumber}")
    public Parcel getParcelByTrackingNumber(@PathVariable String trackingNumber) {
        return parcelService.getByTrackingNumber(trackingNumber)
                .orElseThrow(() -> new RuntimeException("Parcel not found"));
    }

    @PutMapping("/{id}")
    public Parcel updateParcel(@PathVariable Long id, @RequestBody Parcel parcel) {
        return parcelService.updateParcel(id, parcel);
    }

    @DeleteMapping("/{id}")
    public void deleteParcel(@PathVariable Long id) {
        parcelService.deleteParcel(id);
    }
}
