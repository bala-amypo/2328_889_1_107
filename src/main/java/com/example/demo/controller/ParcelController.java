package com.example.demo.controller;

import com.example.demo.model.Parcel;
import com.example.demo.service.ParcelService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/parcels")
public class ParcelController {

    private final ParcelService parcelService;
    public ParcelController(ParcelService parcelService) { this.parcelService = parcelService; }

    @PostMapping
    public Parcel addParcel(@RequestBody Parcel parcel) { return parcelService.addParcel(parcel); }

    @GetMapping("/{id}")
    public Parcel getParcel(@PathVariable Long id) { return parcelService.getParcel(id); }

    @GetMapping
    public List<Parcel> getAllParcels() { return parcelService.getAllParcels(); }

    @PutMapping
    public Parcel updateParcel(@RequestBody Parcel parcel) { return parcelService.updateParcel(parcel); }

    @DeleteMapping("/{id}")
    public void deleteParcel(@PathVariable Long id) { parcelService.deleteParcel(id); }
}
