package com.example.demo.repository;

import com.example.demo.model.Evidence;
import com.example.demo.model.DamageClaim;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EvidenceRepository extends JpaRepository<Evidence, Long> {
    // For Service Logic
    List<Evidence> findByDamageClaim(DamageClaim damageClaim);

    // For MasterTestSuiteTest Logic (using underscore for nested property ID)
    List<Evidence> findByDamageClaim_Id(Long claimId);
    long countByDamageClaim_Id(Long claimId);
}