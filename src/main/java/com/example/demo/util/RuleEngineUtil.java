package com.example.demo.util;

import com.example.demo.model.ClaimRule;
import java.util.List;

public class RuleEngineUtil {
    private RuleEngineUtil() {}

    // The test case specifically calls this method name
    public static double computeScore(String policyType, List<ClaimRule> rules) {
        if (rules == null || rules.isEmpty()) return 0.0;
        double total = 0.0;
        for (ClaimRule rule : rules) {
            total += rule.getWeight();
        }
        return total;
    }
}