package com.example.demo.controller;

import com.example.demo.model.ClaimRule;
import com.example.demo.service.ClaimRuleService;
import com.example.demo.dto.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
@Tag(name = "ClaimRule", description = "Claim rule management APIs")
public class ClaimRuleController {

    private final ClaimRuleService ruleService;

    public ClaimRuleController(ClaimRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    @Operation(summary = "Add a new claim rule")
    public ResponseEntity<?> addRule(@RequestBody ClaimRule rule) {
        ClaimRule savedRule = ruleService.addRule(rule);
        return ResponseEntity.ok(new ApiResponse(true, "Rule added successfully", savedRule));
    }

    @GetMapping
    @Operation(summary = "Get all claim rules")
    public ResponseEntity<?> getAllRules() {
        List<ClaimRule> rules = ruleService.getAllRules();
        return ResponseEntity.ok(new ApiResponse(true, "Rules retrieved successfully", rules));
    }
}
