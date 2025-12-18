package com.example.demo.controller;

import com.example.demo.model.ClaimRule;
import com.example.demo.service.ClaimRuleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class ClaimRuleController {

    private final ClaimRuleService service;

    public ClaimRuleController(ClaimRuleService service) {
        this.service = service;
    }

    @PostMapping
    public ClaimRule add(@RequestBody ClaimRule rule) {
        return service.addRule(rule);
    }

    @GetMapping
    public List<ClaimRule> list() {
        return service.getAllRules();
    }
}
