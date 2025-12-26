// src/main/java/com/example/demo/controller/EvidenceController.java
package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.model.Evidence;
import com.example.demo.service.EvidenceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evidence")
public class EvidenceController {

    private final EvidenceService evidenceService;

    public EvidenceController(EvidenceService evidenceService) {
        this.evidenceService = evidenceService;
    }

    @PostMapping("/upload/{claimId}")
    public ApiResponse upload(@PathVariable Long claimId,
                              @RequestBody Evidence evidence) {
        return new ApiResponse(true, "Evidence uploaded",
                evidenceService.uploadEvidence(claimId, evidence));
    }

    @GetMapping("/claim/{claimId}")
    public ApiResponse getEvidence(@PathVariable Long claimId) {
        return new ApiResponse(true, "Evidence list",
                evidenceService.getEvidenceForClaim(claimId));
    }
}
