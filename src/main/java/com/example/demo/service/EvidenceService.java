package com.example.demo.service;

import com.example.demo.model.Evidence;

public interface EvidenceService {

    Evidence uploadEvidence(Long claimId, Evidence evidence);
}
