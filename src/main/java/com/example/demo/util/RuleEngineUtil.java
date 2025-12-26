package com.example.demo.util;

import com.example.demo.model.ClaimRule;
import com.example.demo.model.DamageClaim;
import java.util.List;
import java.util.stream.Collectors;

public class RuleEngineUtil {

    // --- FOR THE TEST FILE ---
    public static double computeScore(String description, List<ClaimRule> rules) {
        return calculateInternal(description, rules);
    }

    // --- FOR THE SERVICE ---
    public static double calculateScore(DamageClaim claim, List<ClaimRule> rules) {
        return calculateInternal(claim.getClaimDescription(), rules);
    }

    public static List<ClaimRule> getAppliedRules(DamageClaim claim, List<ClaimRule> rules) {
        String desc = (claim.getClaimDescription() == null) ? "" : claim.getClaimDescription().toLowerCase();
        return rules.stream()
                .filter(rule -> {
                    String expr = rule.getRuleExpression().toLowerCase();
                    return expr.equals("always") || 
                           (expr.contains(":") && desc.contains(expr.split(":")[1].trim()));
                })
                .collect(Collectors.toList());
    }

    // Shared logic to satisfy both callers
    private static double calculateInternal(String description, List<ClaimRule> rules) {
        if (rules == null || rules.isEmpty()) return 0.0;
        String desc = (description == null) ? "" : description.toLowerCase();

        boolean anyMatch = rules.stream().anyMatch(rule -> {
            String expr = rule.getRuleExpression().toLowerCase();
            if (expr.equals("always")) return true;
            if (expr.contains(":")) {
                String keyword = expr.split(":")[1].trim();
                return desc.contains(keyword);
            }
            return false;
        });

        return anyMatch ? 1.0 : 0.0;
    }
}