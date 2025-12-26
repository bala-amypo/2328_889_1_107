package com.example.demo.util;

import com.example.demo.model.ClaimRule;
import java.util.List;

public class RuleEngineUtil {
    public static double computeScore(String description, List<ClaimRule> rules) {
        // Test 56 & 57: Handle null/empty rules or descriptions
        if (rules == null || rules.isEmpty()) return 0.0;
        
        double totalWeight = 0;
        double matchedWeight = 0;

        for (ClaimRule rule : rules) {
            totalWeight += rule.getWeight();
            String expr = rule.getExpression() != null ? rule.getExpression().toLowerCase() : "";

            // Test 13: Always rule
            if (expr.equals("always")) {
                matchedWeight += rule.getWeight();
            } 
            // Test 14: Keyword match (case insensitive)
            else if (description != null && expr.startsWith("description_contains:")) {
                String keyword = expr.split(":")[1].toLowerCase();
                if (description.toLowerCase().contains(keyword)) {
                    matchedWeight += rule.getWeight();
                }
            }
        }

        // Test 59 & 15: Handle zero weight or no matches
        if (totalWeight <= 0) return 0.0;
        return matchedWeight / totalWeight;
    }
}