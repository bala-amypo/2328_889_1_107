package com.example.demo.controller;

import com.example.demo.model.Parcel;
import com.example.demo.service.ParcelService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parcels")
public class ParcelController {

    private final ParcelService service;

    public ParcelController(ParcelService service) {
        this.service = service;
    }

    @PostMapping
    public Parcel add(@RequestBody Parcel parcel) {
        return service.addParcel(parcel);
    }

    @GetMapping("/tracking/{trackingNumber}")
    public Parcel get(@PathVariable String trackingNumber) {
        return service.getByTrackingNumber(trackingNumber);
    }
}
