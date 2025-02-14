package com.example.parkinglotmanagement.dto;

import lombok.Getter;

@Getter
public class CreateParkingLotResponse {
    private final String message;
    public CreateParkingLotResponse(String message) {
        this.message = message;
    }
}
