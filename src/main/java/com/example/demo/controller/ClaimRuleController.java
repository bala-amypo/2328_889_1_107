// src/main/java/com/example/demo/controller/ClaimRuleController.java
package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.model.ClaimRule;
import com.example.demo.service.ClaimRuleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rules")
public class ClaimRuleController {

    private final ClaimRuleService ruleService;

    public ClaimRuleController(ClaimRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    public ApiResponse addRule(@RequestBody ClaimRule rule) {
        return new ApiResponse(true, "Rule added",
                ruleService.addRule(rule));
    }

    @GetMapping
    public ApiResponse getAll() {
        return new ApiResponse(true, "Rules fetched",
                ruleService.getAllRules());
    }
}
