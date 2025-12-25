package com.example.demo.repository;

import com.example.demo.model.Evidence;
import com.example.demo.model.DamageClaim;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EvidenceRepository extends JpaRepository<Evidence, Long> {
    
    // REQUIRED: Fixes errors on lines 565, 566, 572, 656, 657
    long countByDamageClaim_Id(Long claimId);
    List<Evidence> findByDamageClaim_Id(Long claimId);
    
    // For your internal Service
    List<Evidence> findByDamageClaim(DamageClaim damageClaim);
}