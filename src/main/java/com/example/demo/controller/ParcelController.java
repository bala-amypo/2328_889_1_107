package com.example.demo.controller;

import com.example.demo.model.Parcel;
import com.example.demo.service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parcels")
public class ParcelController {

    @Autowired
    private ParcelService parcelService;

    @PostMapping
    public Parcel createParcel(@RequestBody Parcel parcel) {
        return parcelService.createParcel(parcel);
    }

    @GetMapping
    public List<Parcel> getAllParcels() {
        return parcelService.getAllParcels();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parcel> getParcelById(@PathVariable Long id) {
        return parcelService.getParcelById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Parcel updateParcel(@PathVariable Long id, @RequestBody Parcel parcel) {
        return parcelService.updateParcel(id, parcel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParcel(@PathVariable Long id) {
        parcelService.deleteParcel(id);
        return ResponseEntity.noContent().build();
    }
}
