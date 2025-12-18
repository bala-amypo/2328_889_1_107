package com.example.demo.controller;

import com.example.demo.model.DamageClaim;
import com.example.demo.service.DamageClaimService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/claims")
public class DamageClaimController {

    private final DamageClaimService service;

    public DamageClaimController(DamageClaimService service) {
        this.service = service;
    }

    @PostMapping("/file/{parcelId}")
    public DamageClaim file(@PathVariable Long parcelId,
                            @RequestBody DamageClaim claim) {
        return service.fileClaim(parcelId, claim);
    }

    @PutMapping("/evaluate/{claimId}")
    public DamageClaim evaluate(@PathVariable Long claimId) {
        return service.evaluateClaim(claimId);
    }

    @GetMapping("/{claimId}")
    public DamageClaim get(@PathVariable Long claimId) {
        return service.evaluateClaim(claimId);
    }
}
