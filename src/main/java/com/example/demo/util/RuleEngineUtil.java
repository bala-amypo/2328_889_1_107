package com.example.demo.util;

import com.example.demo.model.ClaimRule;
import com.example.demo.model.DamageClaim;
import java.util.List;
import java.util.Set;

public class RuleEngineUtil {
    private RuleEngineUtil() {}

    // Used by DamageClaimServiceImpl
    public static double evaluate(DamageClaim claim, List<ClaimRule> rules, Set<ClaimRule> appliedRules) {
        double score = 0.0;
        if (rules == null) return 0.0;
        for (ClaimRule rule : rules) {
            if (claim.getClaimDescription() != null && rule.getConditionExpression() != null) {
                if (claim.getClaimDescription().toLowerCase().contains(rule.getConditionExpression().toLowerCase())) {
                    score += rule.getWeight();
                    appliedRules.add(rule);
                }
            }
        }
        return Math.min(score, 1.0);
    }

    // Used by MasterTestSuiteTest
    public static double computeScore(String policyType, List<ClaimRule> rules) {
        if (rules == null) return 0.0;
        return rules.stream().mapToDouble(ClaimRule::getWeight).sum();
    }
}