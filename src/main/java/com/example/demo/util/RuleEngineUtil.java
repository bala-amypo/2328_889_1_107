package com.example.demo.util;

import com.example.demo.model.ClaimRule;
import com.example.demo.model.DamageClaim;

import java.util.List;

public class RuleEngineUtil {

    public static double evaluate(DamageClaim claim, List<ClaimRule> rules) {
        if (rules == null || rules.isEmpty()) return 0.0;

        double totalWeight = 0.0;
        double matchedWeight = 0.0;

        for (ClaimRule rule : rules) {
            double weight = rule.getWeight() != null ? rule.getWeight() : 0.0;
            totalWeight += weight;

            String condition = rule.getConditionExpression();
            if (condition == null) continue;

            boolean matches = false;

            if ("always".equalsIgnoreCase(condition)) {
                matches = true;
            } else if (condition.toLowerCase().startsWith("description_contains:")) {
                String keyword = condition.substring(21).trim().toLowerCase();
                if (claim.getClaimDescription() != null &&
                        claim.getClaimDescription().toLowerCase().contains(keyword)) {
                    matches = true;
                }
            }

            if (matches) {
                matchedWeight += weight;
            }
        }

        return totalWeight > 0 ? matchedWeight / totalWeight : 0.0;
    }
}
