package com.example.demo.repository;

import com.example.demo.model.Evidence;
import com.example.demo.model.DamageClaim;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EvidenceRepository extends JpaRepository<Evidence, Long> {
    // Add this to fix the Service error
    List<Evidence> findByDamageClaim(DamageClaim damageClaim);

    // Keep these for the Test Suite
    long countByClaim_Id(Long claimId);
    List<Evidence> findByClaim_Id(Long claimId);
}