package com.example.demo.service.impl;

import com.example.demo.model.DamageClaim;
import com.example.demo.repository.DamageClaimRepository;
import org.springframework.stereotype.Service;
import com.example.demo.service.DamageClaimService;
import java.util.List;

@Service
public class DamageClaimServiceImpl implements DamageClaimService {

    private final DamageClaimRepository claimRepository;
    public DamageClaimServiceImpl(DamageClaimRepository claimRepository) { this.claimRepository = claimRepository; }

    @Override
    public DamageClaim createClaim(DamageClaim claim) { return claimRepository.save(claim); }

    @Override
    public DamageClaim getClaim(Long id) { return claimRepository.findById(id).orElse(null); }

    @Override
    public List<DamageClaim> getAllClaims() { return claimRepository.findAll(); }

    @Override
    public DamageClaim updateClaim(DamageClaim claim) { return claimRepository.save(claim); }

    @Override
    public void deleteClaim(Long id) { claimRepository.deleteById(id); }
}
