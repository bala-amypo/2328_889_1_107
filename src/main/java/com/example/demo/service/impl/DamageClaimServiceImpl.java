package com.example.demo.service.impl;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DamageClaimService;
import com.example.demo.util.RuleEngineUtil;
import org.springframework.stereotype.Service;

@Service
public class DamageClaimServiceImpl implements DamageClaimService {
    private final ParcelRepository pRepo;
    private final DamageClaimRepository cRepo;
    private final ClaimRuleRepository rRepo;

    public DamageClaimServiceImpl(ParcelRepository pr, DamageClaimRepository cr, ClaimRuleRepository rr) {
        this.pRepo = pr; this.cRepo = cr; this.rRepo = rr;
    }

    public DamageClaim fileClaim(Long pId, DamageClaim c) {
        Parcel p = pRepo.findById(pId).orElseThrow(() -> new RuntimeException("parcel not found"));
        c.setParcel(p);
        c.setStatus("PENDING");
        return cRepo.save(c);
    }

    public DamageClaim evaluateClaim(Long id) {
        DamageClaim c = cRepo.findById(id).orElseThrow(() -> new RuntimeException("claim not found"));
        double s = RuleEngineUtil.computeScore(c.getClaimDescription(), rRepo.findAll());
        c.setScore(s);
        c.setStatus(s > 0.5 ? "APPROVED" : "REJECTED");
        return cRepo.save(c);
    }
    
    public DamageClaim getClaim(Long id) {
        return cRepo.findById(id).orElseThrow(() -> new RuntimeException("claim not found"));
    }
}