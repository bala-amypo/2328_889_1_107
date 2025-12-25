package com.example.demo.service;

import com.example.demo.model.Evidence;
import com.example.demo.model.DamageClaim;
import java.util.List;

public interface EvidenceService {
    Evidence uploadEvidence(Evidence evidence, DamageClaim claim);
    List<Evidence> getEvidenceForClaim(Long claimId);
}