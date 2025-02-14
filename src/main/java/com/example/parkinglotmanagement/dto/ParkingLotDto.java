package com.example.parkinglotmanagement.dto;

import lombok.Data;

import java.util.Map;

@Data
public class ParkingLotDto {
    private String parkingLotName;
    private int numberOfLevels;
    private Map<String,Integer> numberOfSpots;
}
