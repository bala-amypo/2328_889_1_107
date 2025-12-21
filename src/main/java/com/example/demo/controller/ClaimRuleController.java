package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClaimRuleController {

    @GetMapping("/claim-rule")
    public ApiResponse getClaimRule() {
        return new ApiResponse("Claim Rule fetched successfully");
    }
}
