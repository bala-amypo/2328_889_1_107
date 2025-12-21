package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DamageClaimController {

    @GetMapping("/damage-claim")
    public ApiResponse getDamageClaim() {
        return new ApiResponse("Damage Claim fetched successfully");
    }
}
