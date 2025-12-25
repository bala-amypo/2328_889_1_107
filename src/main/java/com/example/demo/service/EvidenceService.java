package com.example.demo.service;

import com.example.demo.model.Evidence;
import java.util.List;

public interface EvidenceService {
    // This signature matches your Controller's needs
    Evidence uploadEvidence(Long claimId, Evidence evidence);
    
    List<Evidence> getEvidenceForClaim(Long claimId);
}