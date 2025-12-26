package com.example.demo.util;
import com.example.demo.model.ClaimRule;
import java.util.List;

public class RuleEngineUtil {
    public static double computeScore(String desc, List<ClaimRule> rules) {
        if (rules == null || rules.isEmpty()) return 0.0;
        if (desc == null && !rules.stream().anyMatch(r -> r.getExpression().equalsIgnoreCase("always"))) return 0.0;
        
        double matchedWeight = 0;
        double totalWeight = 0;
        
        for (ClaimRule r : rules) {
            totalWeight += r.getWeight();
            String expr = r.getExpression().toLowerCase();
            if (expr.equals("always")) {
                matchedWeight += r.getWeight();
            } else if (desc != null && expr.startsWith("description_contains:")) {
                String key = expr.split(":")[1];
                if (desc.toLowerCase().contains(key.toLowerCase())) {
                    matchedWeight += r.getWeight();
                }
            }
        }
        return totalWeight <= 0 ? 0.0 : matchedWeight / totalWeight;
    }
}