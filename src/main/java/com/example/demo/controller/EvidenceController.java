package com.example.demo.controller;

import com.example.demo.model.Evidence;
import com.example.demo.model.DamageClaim;
import com.example.demo.service.EvidenceService;
import com.example.demo.service.DamageClaimService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evidences")
public class EvidenceController {

    private final EvidenceService evidenceService;
    private final DamageClaimService damageClaimService; // Added to fetch the claim object

    public EvidenceController(EvidenceService evidenceService, DamageClaimService damageClaimService) {
        this.evidenceService = evidenceService;
        this.damageClaimService = damageClaimService;
    }

    @PostMapping("/upload/{claimId}")
    public Evidence uploadEvidence(@PathVariable Long claimId, @RequestBody Evidence evidence) {
        // 1. Fetch the DamageClaim object using the ID from the URL
        DamageClaim claim = damageClaimService.getClaim(claimId);
        
        // 2. Pass the evidence and the actual claim object to the service
        // This matches the signature: uploadEvidence(Evidence evidence, DamageClaim claim)
        return evidenceService.uploadEvidence(evidence, claim);
    }

    @GetMapping("/claim/{claimId}")
    public List<Evidence> getEvidenceForClaim(@PathVariable Long claimId) {
        return evidenceService.getEvidenceForClaim(claimId);
    }
}