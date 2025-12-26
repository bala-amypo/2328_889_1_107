package com.example.demo.controller;
import com.example.demo.model.DamageClaim;
import com.example.demo.service.DamageClaimService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/claims")
public class DamageClaimController {
    private final DamageClaimService service;
    public DamageClaimController(DamageClaimService s) { this.service = s; }

    @PostMapping("/{parcelId}")
    public DamageClaim file(@PathVariable Long parcelId, @RequestBody DamageClaim c) {
        return service.fileClaim(parcelId, c);
    }
}