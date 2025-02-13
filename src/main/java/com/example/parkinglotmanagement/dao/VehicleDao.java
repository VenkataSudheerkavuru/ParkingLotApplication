package com.example.parkinglotmanagement.dao;

import com.example.parkinglotmanagement.dto.VehicleDto;
import com.example.parkinglotmanagement.entities.Spot;
import com.example.parkinglotmanagement.entities.Vehicle;
import com.example.parkinglotmanagement.repository.VehicleRepository;
import org.springframework.stereotype.Component;

@Component
public class VehicleDao {

    private final VehicleRepository vehicleRepository;

    VehicleDao(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public void saveVehicle(Spot spot, VehicleDto vehicleDto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType(vehicleDto.getVehicleType());
        vehicle.setVehicleNumber(vehicleDto.getVehicleNumber());
        vehicle.setSpot(spot);
        vehicleRepository.save(vehicle);
    }
}
