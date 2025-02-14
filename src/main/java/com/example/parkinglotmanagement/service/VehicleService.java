package com.example.parkinglotmanagement.service;

import com.example.parkinglotmanagement.dto.VehicleDto;
import com.example.parkinglotmanagement.entities.Spot;
import com.example.parkinglotmanagement.entities.Vehicle;

public interface VehicleService {
    void saveVehicle(Spot spot, VehicleDto vehicleDto, Vehicle vehicle);

    Vehicle leaveParking(String vehicleNumber);

    Vehicle checkVehicleNumber(VehicleDto vehicleDto);
}
