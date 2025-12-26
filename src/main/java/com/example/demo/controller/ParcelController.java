// src/main/java/com/example/demo/controller/ParcelController.java
package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.model.Parcel;
import com.example.demo.service.ParcelService;
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
        return new ApiResponse(true, "Parcel added", parcelService.addParcel(parcel));
    }

    @GetMapping("/tracking/{trackingNumber}")
    public ApiResponse getByTracking(@PathVariable String trackingNumber) {
        return new ApiResponse(true, "Parcel found",
                parcelService.getByTrackingNumber(trackingNumber));
    }
}
