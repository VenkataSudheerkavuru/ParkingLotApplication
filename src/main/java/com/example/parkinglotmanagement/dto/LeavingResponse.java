package com.example.parkinglotmanagement.dto;

import lombok.Getter;

@Getter
public class LeavingResponse {
    private final String message;

    public LeavingResponse(String message) {
        this.message = message;
    }
}
