package com.example.demo.util;

import com.example.demo.model.ClaimRule;
import java.util.List;

public class RuleEngineUtil {
    
    public static double computeScore(String description, List<ClaimRule> rules) {
        if (description == null || rules.isEmpty()) {
            return 0.0;
        }
        
        double totalWeight = 0.0;
        double matchedWeight = 0.0;
        
        for (ClaimRule rule : rules) {
            totalWeight += rule.getWeight();
            
            if (evaluateRule(rule, description)) {
                matchedWeight += rule.getWeight();
            }
        }
        
        if (totalWeight == 0.0) {
            return 0.0;
        }
        
        return matchedWeight / totalWeight;
    }
    
    private static boolean evaluateRule(ClaimRule rule, String description) {
        String condition = rule.getConditionExpression();
        
        if ("always".equals(condition)) {
            return true;
        }
        
        if (condition.startsWith("description_contains:")) {
            String keyword = condition.substring("description_contains:".length());
            return description.toLowerCase().contains(keyword.toLowerCase());
        }
        
        return false;
    }
}