package com.example.demo.service.impl;

import com.example.demo.model.DamageClaim;
import com.example.demo.model.Evidence;
import com.example.demo.repository.DamageClaimRepository;
import com.example.demo.repository.EvidenceRepository;
import com.example.demo.service.EvidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvidenceServiceImpl implements EvidenceService {

    @Autowired
    private EvidenceRepository evidenceRepository;

    @Autowired
    private DamageClaimRepository damageClaimRepository;

    @Override
    public Evidence uploadEvidence(Long claimId, Evidence evidence) {
        DamageClaim claim = damageClaimRepository.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found"));
        evidence.setClaim(claim);
        return evidenceRepository.save(evidence);
    }

    @Override
    public List<Evidence> getEvidenceForClaim(Long claimId) {
        DamageClaim claim = damageClaimRepository.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found"));
        return evidenceRepository.findByClaim(claim);
    }
}
