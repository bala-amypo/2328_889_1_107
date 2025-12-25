package com.example.demo.service.impl;

import com.example.demo.model.Evidence;
import com.example.demo.model.DamageClaim;
import com.example.demo.repository.EvidenceRepository;
import com.example.demo.service.EvidenceService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EvidenceServiceImpl implements EvidenceService {

    private final EvidenceRepository evidenceRepository;

    public EvidenceServiceImpl(EvidenceRepository evidenceRepository) {
        this.evidenceRepository = evidenceRepository;
    }

    @Override
    public Evidence uploadEvidence(Evidence evidence, DamageClaim claim) {
        // This matches the updated Evidence model field name
        evidence.setDamageClaim(claim); 
        return evidenceRepository.save(evidence);
    }

    @Override
    public List<Evidence> getEvidenceByClaim(DamageClaim claim) {
        // This matches the updated Repository method name
        return evidenceRepository.findByDamageClaim(claim);
    }
}