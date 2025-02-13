package com.example.parkinglotmanagement.dao;

import com.example.parkinglotmanagement.dto.VehicleDto;
import com.example.parkinglotmanagement.entities.Spot;
import com.example.parkinglotmanagement.entities.Vehicle;
import com.example.parkinglotmanagement.exception.ParkingLotException;
import com.example.parkinglotmanagement.repository.SpotRepository;
import com.example.parkinglotmanagement.repository.VehicleRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VehicleDao {

    private final VehicleRepository vehicleRepository;
    private final SpotRepository spotRepository;

    VehicleDao(VehicleRepository vehicleRepository, SpotRepository spotRepository) {
        this.vehicleRepository = vehicleRepository;
        this.spotRepository = spotRepository;
    }

    public void saveVehicle(Spot spot, VehicleDto vehicleDto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType(vehicleDto.getVehicleType());
        vehicle.setVehicleNumber(vehicleDto.getVehicleNumber());
        vehicle.setSpot(spot);
        vehicleRepository.save(vehicle);
    }

    public Vehicle findByVehicleNumber(String vehicleNumber) {
        List<Vehicle> vehicleList = vehicleRepository.findVehicleByVehicleNumber(vehicleNumber);
        if(vehicleList.isEmpty()){
            throw new ParkingLotException("Vehicle not found");
        }
        Vehicle vehicle = vehicleList.get(vehicleList.size()-1);
        vehicleRepository.delete(vehicle);
        return vehicle;
    }

    public void makeSpotAvailable(Spot spot) {
        spot.setAvailable(true);
        spotRepository.save(spot);
    }

    public void checkVehicleNumber(String vehicleNumber) {
        if(!vehicleRepository.findVehicleByVehicleNumber(vehicleNumber).isEmpty()) {
            throw new ParkingLotException("Enter correct vehicle number");
        };
    }
}
