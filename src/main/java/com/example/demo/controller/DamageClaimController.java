package com.example.demo.controller;

import com.example.demo.model.DamageClaim;
import com.example.demo.service.DamageClaimService;
import com.example.demo.dto.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/claims")
@Tag(name = "DamageClaim", description = "Damage Claim management APIs")
public class DamageClaimController {

    private final DamageClaimService claimService;

    public DamageClaimController(DamageClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping("/file/{parcelId}")
    @Operation(summary = "File a new damage claim for a parcel")
    public ResponseEntity<?> fileClaim(@PathVariable Long parcelId, @RequestBody DamageClaim claim) {
        DamageClaim savedClaim = claimService.fileClaim(parcelId, claim);
        return ResponseEntity.ok(new ApiResponse(true, "Claim filed successfully", savedClaim));
    }

    @PutMapping("/evaluate/{claimId}")
    @Operation(summary = "Evaluate a claim using rule engine")
    public ResponseEntity<?> evaluateClaim(@PathVariable Long claimId) {
        DamageClaim evaluatedClaim = claimService.evaluateClaim(claimId);
        return ResponseEntity.ok(new ApiResponse(true, "Claim evaluated successfully", evaluatedClaim));
    }

    @GetMapping("/{claimId}")
    @Operation(summary = "Get claim by ID")
    public ResponseEntity<?> getClaim(@PathVariable Long claimId) {
        DamageClaim claim = claimService.getClaim(claimId);
        return ResponseEntity.ok(new ApiResponse(true, "Claim retrieved successfully", claim));
    }
}
