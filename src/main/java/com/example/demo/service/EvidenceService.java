package com.example.demo.service;

import com.example.demo.model.Evidence;
import java.util.List;

public interface EvidenceService {
    Evidence createEvidence(Evidence evidence);
    Evidence getEvidence(Long id);
    List<Evidence> getAllEvidence();
    Evidence updateEvidence(Evidence evidence);
    void deleteEvidence(Long id);
}
