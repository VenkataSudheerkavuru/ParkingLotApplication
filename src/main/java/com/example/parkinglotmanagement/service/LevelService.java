package com.example.parkinglotmanagement.service;

import com.example.parkinglotmanagement.dto.VehicleDto;
import com.example.parkinglotmanagement.entities.ParkingLot;

import java.util.Map;

public interface LevelService {

    void addSpotsToLevels(Long parkingLotId, Map<String, Integer> numberOfSpots);

    void addLevelsToParkingLot(ParkingLot parkingLot, int numberOfLevels, Map<String, Integer> numberOfSpots);

    void parkVehicleAtLevel(Long parkingLotId, VehicleDto vehicleDto);

    Double leaveParking(String vehicleNumber, CalculateFee calculateFee);
}
