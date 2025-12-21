package com.example.demo.controller;

import com.example.demo.model.DamageClaim;
import com.example.demo.service.DamageClaimService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/claims")
public class DamageClaimController {

    private final DamageClaimService claimService;
    public DamageClaimController(DamageClaimService claimService) { this.claimService = claimService; }

    @PostMapping
    public DamageClaim createClaim(@RequestBody DamageClaim claim) { return claimService.createClaim(claim); }

    @GetMapping("/{id}")
    public DamageClaim getClaim(@PathVariable Long id) { return claimService.getClaim(id); }

    @GetMapping
    public List<DamageClaim> getAllClaims() { return claimService.getAllClaims(); }

    @PutMapping
    public DamageClaim updateClaim(@RequestBody DamageClaim claim) { return claimService.updateClaim(claim); }

    @DeleteMapping("/{id}")
    public void deleteClaim(@PathVariable Long id) { claimService.deleteClaim(id); }
}
