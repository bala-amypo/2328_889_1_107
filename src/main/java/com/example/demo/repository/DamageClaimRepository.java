package com.example.demo.repository;

import com.example.demo.model.DamageClaim;
import com.example.demo.model.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DamageClaimRepository extends JpaRepository<DamageClaim, Long> {
    
    // REQUIRED: Test suite calls findByParcel
    List<DamageClaim> findByParcel(Parcel parcel);

    // REQUIRED: Test suite calls findByStatus (Fixes errors on lines 607, 608)
    List<DamageClaim> findByStatus(String status);

    // This is already correct for internal logic
    List<DamageClaim> findByParcel_Id(Long parcelId);
}