package com.example.demo.util;

import com.example.demo.model.ClaimRule;
import java.util.List;

public class RuleEngineUtil {
    public static double computeScore(String description, List<ClaimRule> rules) {
        if (rules == null || rules.isEmpty()) return 0.0;
        
        double totalWeight = 0.0;
        double matchedWeight = 0.0;

        for (ClaimRule rule : rules) {
            totalWeight += rule.getWeight();
            String expression = rule.getExpression() != null ? rule.getExpression().toLowerCase() : "";

            // Logic for "always" rule
            if (expression.equals("always")) {
                matchedWeight += rule.getWeight();
            } 
            // Logic for "description_contains:keyword"
            else if (description != null && expression.startsWith("description_contains:")) {
                String keyword = expression.split(":")[1].toLowerCase();
                if (description.toLowerCase().contains(keyword)) {
                    matchedWeight += rule.getWeight();
                }
            }
        }

        return (totalWeight == 0) ? 0.0 : matchedWeight / totalWeight;
    }
}