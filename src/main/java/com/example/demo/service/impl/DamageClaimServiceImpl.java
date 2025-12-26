package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DamageClaimService;
import com.example.demo.util.RuleEngineUtil;

import java.util.List;

public class DamageClaimServiceImpl implements DamageClaimService {

    private final ParcelRepository parcelRepo;
    private final DamageClaimRepository claimRepo;
    private final ClaimRuleRepository ruleRepo;

    public DamageClaimServiceImpl(ParcelRepository p, DamageClaimRepository c, ClaimRuleRepository r) {
        this.parcelRepo = p;
        this.claimRepo = c;
        this.ruleRepo = r;
    }

    public DamageClaim fileClaim(Long parcelId, DamageClaim claim) {
        Parcel p = parcelRepo.findById(parcelId)
                .orElseThrow(() -> new RuntimeException("Parcel not found"));
        claim.setParcel(p);
        claim.setStatus("PENDING");
        return claimRepo.save(claim);
    }

    public DamageClaim evaluateClaim(Long claimId) {
        DamageClaim c = claimRepo.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found"));

        List<ClaimRule> rules = ruleRepo.findAll();
        double score = RuleEngineUtil.computeScore(c.getClaimDescription(), rules);
        c.setScore(score);

        if (score > 0)
            c.setStatus("APPROVED");
        else
            c.setStatus("REJECTED");

        return claimRepo.save(c);
    }

    public DamageClaim getClaim(Long id) {
        return claimRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Claim not found"));
    }
}
