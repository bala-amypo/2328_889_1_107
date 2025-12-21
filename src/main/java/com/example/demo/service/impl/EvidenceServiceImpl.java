package com.example.demo.service.impl;

import com.example.demo.model.Evidence;
import com.example.demo.repository.EvidenceRepository;
import com.example.demo.service.EvidenceService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EvidenceServiceImpl implements EvidenceService {

    private final EvidenceRepository evidenceRepository;
    public EvidenceServiceImpl(EvidenceRepository evidenceRepository) { this.evidenceRepository = evidenceRepository; }

    @Override
    public Evidence createEvidence(Evidence evidence) { return evidenceRepository.save(evidence); }

    @Override
    public Evidence getEvidence(Long id) { return evidenceRepository.findById(id).orElse(null); }

    @Override
    public List<Evidence> getAllEvidence() { return evidenceRepository.findAll(); }

    @Override
    public Evidence updateEvidence(Evidence evidence) { return evidenceRepository.save(evidence); }

    @Override
    public void deleteEvidence(Long id) { evidenceRepository.deleteById(id); }
}
