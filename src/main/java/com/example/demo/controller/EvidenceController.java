package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EvidenceController {

    @GetMapping("/evidence")
    public ApiResponse getEvidence() {
        return new ApiResponse("Evidence fetched successfully");
    }
}
