package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParcelController {

    @GetMapping("/parcel")
    public ApiResponse getParcel() {
        return new ApiResponse("Parcel fetched successfully");
    }
}
