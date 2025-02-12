package com.example.parkinglotmanagement.service;

import com.example.parkinglotmanagement.dto.ParkingLotDto;
import com.example.parkinglotmanagement.dto.VehicleDto;

public interface ParkingLotService {

    void createParkingLot(ParkingLotDto parkingLotDto);

    void parkVehicle(Long parkingLotId, VehicleDto vehicleDto);

    void leaveParking(Long parkingLotId, String vehicleNumber);
}
