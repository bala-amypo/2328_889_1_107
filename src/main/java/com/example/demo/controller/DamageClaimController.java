// src/main/java/com/example/demo/controller/DamageClaimController.java
package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.model.DamageClaim;
import com.example.demo.service.DamageClaimService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/claims")
public class DamageClaimController {

    private final DamageClaimService claimService;

    public DamageClaimController(DamageClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping("/file/{parcelId}")
    public ApiResponse fileClaim(@PathVariable Long parcelId,
                                 @RequestBody DamageClaim claim) {
        return new ApiResponse(true, "Claim filed",
                claimService.fileClaim(parcelId, claim));
    }

    @PutMapping("/evaluate/{claimId}")
    public ApiResponse evaluate(@PathVariable Long claimId) {
        return new ApiResponse(true, "Claim evaluated",
                claimService.evaluateClaim(claimId));
    }

    @GetMapping("/{claimId}")
    public ApiResponse getClaim(@PathVariable Long claimId) {
        return new ApiResponse(true, "Claim fetched",
                claimService.getClaim(claimId));
    }
}
