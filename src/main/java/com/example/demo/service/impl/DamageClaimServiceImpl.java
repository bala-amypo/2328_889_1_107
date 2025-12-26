package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ClaimRule;
import com.example.demo.model.DamageClaim;
import com.example.demo.model.Parcel;
import com.example.demo.repository.ClaimRuleRepository;
import com.example.demo.repository.DamageClaimRepository;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.service.DamageClaimService;
import com.example.demo.util.RuleEngineUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DamageClaimServiceImpl implements DamageClaimService {

    private final ParcelRepository parcelRepository;
    private final DamageClaimRepository claimRepository;
    private final ClaimRuleRepository ruleRepository;

    public DamageClaimServiceImpl(ParcelRepository parcelRepository,
                                  DamageClaimRepository claimRepository,
                                  ClaimRuleRepository ruleRepository) {
        this.parcelRepository = parcelRepository;
        this.claimRepository = claimRepository;
        this.ruleRepository = ruleRepository;
    }

    @Override
    public DamageClaim fileClaim(Long parcelId, DamageClaim claim) {
        Parcel parcel = parcelRepository.findById(parcelId)
                .orElseThrow(() -> new ResourceNotFoundException("Parcel not found"));

        claim.setParcel(parcel);
        claim.setStatus("PENDING");
        claim.setFiledAt(LocalDateTime.now());

        return claimRepository.save(claim);
    }

    @Override
    public DamageClaim evaluateClaim(Long claimId) {
        DamageClaim claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found"));

        List<ClaimRule> rules = ruleRepository.findAll();
        double score = RuleEngineUtil.calculateScore(claim, rules);
        claim.setScore(score);
        claim.setStatus(score > 0.9 ? "APPROVED" : (score == 0.0 ? "REJECTED" : "PENDING"));
        claim.setAppliedRules(RuleEngineUtil.getAppliedRules(claim, rules));

        return claimRepository.save(claim);
    }

    @Override
    public DamageClaim getClaim(Long claimId) {
        return claimRepository.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found"));
    }
}
