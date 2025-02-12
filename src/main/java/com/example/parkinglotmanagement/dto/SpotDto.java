package com.example.parkinglotmanagement.dto;

import lombok.Data;

import java.util.Map;

@Data
public class SpotDto {

    private Map<String,Integer> spotsPerVehicle;

}
