package com.example.demo.controller;

import com.example.demo.model.Parcel;
import com.example.demo.service.ParcelService;
import com.example.demo.dto.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parcels")
@Tag(name = "Parcel", description = "Parcel management APIs")
public class ParcelController {

    private final ParcelService parcelService;

    public ParcelController(ParcelService parcelService) {
        this.parcelService = parcelService;
    }

    @PostMapping
    @Operation(summary = "Add a new parcel")
    public ResponseEntity<?> addParcel(@RequestBody Parcel parcel) {
        Parcel savedParcel = parcelService.addParcel(parcel);
        return ResponseEntity.ok(new ApiResponse(true, "Parcel added successfully", savedParcel));
    }

    @GetMapping("/tracking/{trackingNumber}")
    @Operation(summary = "Get parcel by tracking number")
    public ResponseEntity<?> getParcel(@PathVariable String trackingNumber) {
        Parcel parcel = parcelService.getByTrackingNumber(trackingNumber);
        return ResponseEntity.ok(new ApiResponse(true, "Parcel retrieved successfully", parcel));
    }
}
