package com.example.demo.util;

import com.example.demo.model.ClaimRule;
import com.example.demo.model.DamageClaim;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RuleEngineUtil {

    /**
     * Calculates the score of a claim based on the list of rules.
     * Score ranges from 0.0 to 1.0.
     */
    public static double calculateScore(DamageClaim claim, List<ClaimRule> rules) {
        if (rules == null || rules.isEmpty()) return 0.0;

        double totalWeight = 0.0;
        double appliedWeight = 0.0;

        for (ClaimRule rule : rules) {
            totalWeight += rule.getWeight();
            if (applies(rule, claim)) {
                appliedWeight += rule.getWeight();
            }
        }

        return totalWeight == 0.0 ? 0.0 : appliedWeight / totalWeight;
    }

    /**
     * Returns the set of rules that were applied to this claim.
     */
    public static Set<ClaimRule> getAppliedRules(DamageClaim claim, List<ClaimRule> rules) {
        Set<ClaimRule> appliedRules = new HashSet<>();
        for (ClaimRule rule : rules) {
            if (applies(rule, claim)) {
                appliedRules.add(rule);
            }
        }
        return appliedRules;
    }

    /**
     * Determines if a rule applies to a given claim.
     * Special rule: "always" always matches.
     * Special rule: "description_contains:KEYWORD"
     */
    private static boolean applies(ClaimRule rule, DamageClaim claim) {
        if (rule.getConditionExpression() == null) return false;
        String condition = rule.getConditionExpression().trim().toLowerCase();
        String description = claim.getClaimDescription() == null ? "" : claim.getClaimDescription().toLowerCase();

        if (condition.equals("always")) return true;
        if (condition.startsWith("description_contains:")) {
            String keyword = condition.substring("description_contains:".length());
            return description.contains(keyword.toLowerCase());
        }
        return false;
    }
}
