package com.example.demo.repository;

import com.example.demo.model.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EvidenceRepository extends JpaRepository<Evidence, Long> {
    // The underscore _Id is the Spring Data JPA way to reference the ID of the damageClaim field
    List<Evidence> findByDamageClaim_Id(Long claimId);
    long countByDamageClaim_Id(Long claimId);
}