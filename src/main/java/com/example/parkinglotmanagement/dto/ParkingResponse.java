package com.example.parkinglotmanagement.dto;

import lombok.Data;

@Data
public class ParkingResponse {
    private final String message;

    public ParkingResponse(String message) {
        this.message = message;
    }
}
