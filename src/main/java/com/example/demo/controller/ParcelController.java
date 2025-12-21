package com.example.demo.controller;

import com.example.demo.model.Parcel;
import com.example.demo.service.ParcelService;
import com.example.demo.dto.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parcels")
public class ParcelController {

    private final ParcelService parcelService;

    public ParcelController(ParcelService parcelService) {
        this.parcelService = parcelService;
    }

    @PostMapping
    public ApiResponse addParcel(@RequestBody Parcel parcel) {
        Parcel savedParcel = parcelService.addParcel(parcel);
        return new ApiResponse(true, "Parcel added successfully", savedParcel);
    }

    @GetMapping("/tracking/{trackingNumber}")
    public Parcel getParcel(@PathVariable String trackingNumber) {
        return parcelService.getByTrackingNumber(trackingNumber);
    }
}
