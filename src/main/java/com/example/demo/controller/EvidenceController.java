package com.example.demo.controller;

import com.example.demo.model.Evidence;
import com.example.demo.service.EvidenceService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/evidence")
public class EvidenceController {

    private final EvidenceService evidenceService;
    public EvidenceController(EvidenceService evidenceService) { this.evidenceService = evidenceService; }

    @PostMapping
    public Evidence createEvidence(@RequestBody Evidence evidence) { return evidenceService.createEvidence(evidence); }

    @GetMapping("/{id}")
    public Evidence getEvidence(@PathVariable Long id) { return evidenceService.getEvidence(id); }

    @GetMapping
    public List<Evidence> getAllEvidence() { return evidenceService.getAllEvidence(); }

    @PutMapping
    public Evidence updateEvidence(@RequestBody Evidence evidence) { return evidenceService.updateEvidence(evidence); }

    @DeleteMapping("/{id}")
    public void deleteEvidence(@PathVariable Long id) { evidenceService.deleteEvidence(id); }
}
