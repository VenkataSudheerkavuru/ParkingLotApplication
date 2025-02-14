package com.example.parkinglotmanagement.service;

import com.example.parkinglotmanagement.dto.ParkingLotDto;
import com.example.parkinglotmanagement.dto.SpotDto;
import com.example.parkinglotmanagement.dto.VehicleDto;

import java.util.List;

public interface ParkingLotService {

    void createParkingLot(ParkingLotDto parkingLotDto);

    void parkVehicle(Long parkingLotId, VehicleDto vehicleDto);

    Double leaveParking( String vehicleNumber);

    List<SpotDto> getAllParkingLots(Long parkingLotId);
}
