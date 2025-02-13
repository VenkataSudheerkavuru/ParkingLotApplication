package com.example.parkinglotmanagement.service;

import com.example.parkinglotmanagement.dto.SpotDto;
import com.example.parkinglotmanagement.dto.VehicleDto;
import com.example.parkinglotmanagement.entities.ParkingLot;

public interface LevelService {

    void addSpotsToLevels(Long parkingLotId, SpotDto spotDto);

    void addLelesToParkingLot(ParkingLot parkingLot, int numberOfLevels);

    void parkVehicleAtLevel(Long parkingLotId, VehicleDto vehicleDto);

    Double leaveParking(String vehicleNumber, CalculateFee calculateFee);
}
