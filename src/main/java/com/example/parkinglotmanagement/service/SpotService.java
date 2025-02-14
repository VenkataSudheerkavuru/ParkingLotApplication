package com.example.parkinglotmanagement.service;

import com.example.parkinglotmanagement.dto.SpotDto;
import com.example.parkinglotmanagement.dto.VehicleDto;
import com.example.parkinglotmanagement.entities.Level;
import com.example.parkinglotmanagement.entities.Spot;

import java.util.List;
import java.util.Map;

public interface SpotService {
    void addSpotsToLevels(Level level, Map<String, Integer> spotsPerVehicle);

    Spot findAvailbleSpot(Level level, String vehicleType);

    void parkVehicle(Spot spot, VehicleDto vehicleDto);

    Double leaveParking(String vehicleNumber, CalculateFee calculateFee);

    List<SpotDto> getSpotsByLevel(Long levelId);
}
