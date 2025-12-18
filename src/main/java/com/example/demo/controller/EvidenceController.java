package com.example.demo.controller;

import com.example.demo.model.Evidence;
import com.example.demo.service.EvidenceService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/evidence")
public class EvidenceController {

    private final EvidenceService service;

    public EvidenceController(EvidenceService service) {
        this.service = service;
    }

    @PostMapping("/upload/{claimId}")
    public Evidence upload(@PathVariable Long claimId,
                           @RequestBody Evidence evidence) {
        return service.uploadEvidence(claimId, evidence);
    }

    @GetMapping("/claim/{claimId}")
    public List<Evidence> list(@PathVariable Long claimId) {
        return service.getEvidenceForClaim(claimId);
    }
}
