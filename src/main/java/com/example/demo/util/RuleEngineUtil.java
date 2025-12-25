package com.example.demo.util;

import com.example.demo.model.ClaimRule;
import com.example.demo.model.DamageClaim;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RuleEngineUtil {

    private RuleEngineUtil() {
    }

    public static double evaluate(
            DamageClaim claim,
            List<ClaimRule> rules,
            Set<ClaimRule> appliedRules
    ) {
        double score = 0.0;

        for (ClaimRule rule : rules) {

            if (matches(rule, claim)) {
                score += rule.getWeight();
                appliedRules.add(rule);
            }
        }

        return Math.min(score, 1.0);
    }

    private static boolean matches(ClaimRule rule, DamageClaim claim) {

        String expr = rule.getConditionExpression();

        if (expr == null) {
            return false;
        }

        if ("always".equalsIgnoreCase(expr)) {
            return true;
        }

        if (expr.startsWith("description_contains:")) {
            String keyword = expr.substring("description_contains:".length());
            return claim.getClaimDescription() != null
                    && claim.getClaimDescription().toLowerCase()
                    .contains(keyword.toLowerCase());
        }

        return false;
    }
}
