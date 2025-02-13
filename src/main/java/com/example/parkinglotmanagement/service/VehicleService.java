package com.example.parkinglotmanagement.service;

import com.example.parkinglotmanagement.dto.VehicleDto;
import com.example.parkinglotmanagement.entities.Spot;

public interface VehicleService {
    void saveVehicle(Spot spot, VehicleDto vehicleDto);
}
