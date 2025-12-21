package com.example.demo.controller;

import com.example.demo.model.ClaimRule;
import com.example.demo.service.ClaimRuleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rules")
public class ClaimRuleController {

    private final ClaimRuleService ruleService;
    public ClaimRuleController(ClaimRuleService ruleService) { this.ruleService = ruleService; }

    @PostMapping
    public ClaimRule createRule(@RequestBody ClaimRule rule) { return ruleService.createRule(rule); }

    @GetMapping("/{id}")
    public ClaimRule getRule(@PathVariable Long id) { return ruleService.getRule(id); }

    @GetMapping
    public List<ClaimRule> getAllRules() { return ruleService.getAllRules(); }

    @PutMapping
    public ClaimRule updateRule(@RequestBody ClaimRule rule) { return ruleService.updateRule(rule); }

    @DeleteMapping("/{id}")
    public void deleteRule(@PathVariable Long id) { ruleService.deleteRule(id); }
}
