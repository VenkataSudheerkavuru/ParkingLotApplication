package com.example.parkinglotmanagement.dto;

import lombok.Data;

@Data
public class SpotDto {
    private Long spotId;
    private int spotNumber;
    private String vehicleType;
    private Boolean isAvailable;
    private String vehicleNumber;

    public SpotDto(Long spotId, int spotNumber, String vehicleType, Boolean isAvailable, String vehicleNumber) {
        this.spotId = spotId;
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
        this.isAvailable = isAvailable;
        this.vehicleNumber = vehicleNumber;
    }
}
