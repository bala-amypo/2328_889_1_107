package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.ClaimRule;
import com.example.demo.repository.ClaimRuleRepository;
import com.example.demo.service.ClaimRuleService;
import org.springframework.stereotype.Service;

@Service
public class ClaimRuleServiceImpl implements ClaimRuleService {

    private final ClaimRuleRepository ruleRepository;

    public ClaimRuleServiceImpl(ClaimRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public ClaimRule addRule(ClaimRule rule) {

        if (rule.getWeight() == null || rule.getWeight() < 0) {
            throw new BadRequestException("weight must be greater than or equal to zero");
        }

        return ruleRepository.save(rule);
    }
}
