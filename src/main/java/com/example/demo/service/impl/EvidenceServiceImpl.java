package com.example.demo.service.impl;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.EvidenceService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EvidenceServiceImpl implements EvidenceService {
    private final EvidenceRepository eRepo;
    private final DamageClaimRepository cRepo;
    public EvidenceServiceImpl(EvidenceRepository er, DamageClaimRepository cr) { this.eRepo = er; this.cRepo = cr; }

    public Evidence uploadEvidence(Long cId, Evidence e) {
        DamageClaim c = cRepo.findById(cId).orElseThrow(() -> new RuntimeException("claim not found"));
        e.setClaim(c);
        return eRepo.save(e);
    }
    public List<Evidence> getEvidenceForClaim(Long cId) { return eRepo.findByClaim_Id(cId); }
}