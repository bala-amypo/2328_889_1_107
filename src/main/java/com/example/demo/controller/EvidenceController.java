package com.example.demo.controller;

import com.example.demo.model.Evidence;
import com.example.demo.service.EvidenceService;
import com.example.demo.dto.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evidence")
@Tag(name = "Evidence", description = "Evidence management APIs")
public class EvidenceController {

    private final EvidenceService evidenceService;

    public EvidenceController(EvidenceService evidenceService) {
        this.evidenceService = evidenceService;
    }

    @PostMapping("/upload/{claimId}")
    @Operation(summary = "Upload evidence for a claim")
    public ResponseEntity<?> uploadEvidence(@PathVariable Long claimId, @RequestBody Evidence evidence) {
        Evidence savedEvidence = evidenceService.uploadEvidence(claimId, evidence);
        return ResponseEntity.ok(new ApiResponse(true, "Evidence uploaded successfully", savedEvidence));
    }

    @GetMapping("/claim/{claimId}")
    @Operation(summary = "Get all evidence for a claim")
    public ResponseEntity<?> getEvidenceForClaim(@PathVariable Long claimId) {
        List<Evidence> evidenceList = evidenceService.getEvidenceForClaim(claimId);
        return ResponseEntity.ok(new ApiResponse(true, "Evidence retrieved successfully", evidenceList));
    }
}
