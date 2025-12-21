package com.example.demo.service;

import com.example.demo.model.ClaimRule;
import java.util.List;

public interface ClaimRuleService {
    ClaimRule createRule(ClaimRule rule);
    ClaimRule getRule(Long id);
    List<ClaimRule> getAllRules();
    ClaimRule updateRule(ClaimRule rule);
    void deleteRule(Long id);
}
