package com.example.parkinglotmanagement.service;

import com.example.parkinglotmanagement.dto.VehicleDto;
import com.example.parkinglotmanagement.entities.Level;
import com.example.parkinglotmanagement.entities.Spot;

import java.util.Map;
import java.util.Optional;

public interface SpotService {
    void addSpotsToLevels(Level level, Map<String, Integer> spotsPerVehicle);

    Optional<Spot> findAvailbleSpot(Level level, String vehicleType);

    void parkVehicle(Spot spot, VehicleDto vehicleDto);
}
