package com.example.parkinglotmanagement.dao;

import com.example.parkinglotmanagement.dto.VehicleDto;
import com.example.parkinglotmanagement.entities.Spot;
import com.example.parkinglotmanagement.entities.Vehicle;
import com.example.parkinglotmanagement.exception.ParkingLotException;
import com.example.parkinglotmanagement.repository.VehicleRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Dao class for vehicle
 */
@Component
public class VehicleDao {

    private final VehicleRepository vehicleRepository;

    VehicleDao(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    /**
     * saving the vehicle info in vehicle class along with spot occupied
     */
    public void saveVehicle(Spot spot, VehicleDto vehicleDto, Vehicle vehicle) {
        if(vehicle == null) {
            vehicle = new Vehicle();
        }
        vehicle.setVehicleType(vehicleDto.getVehicleType());
        vehicle.setVehicleNumber(vehicleDto.getVehicleNumber());
        vehicle.setVehicleEnteredTime(LocalDateTime.now());
        vehicle.setVehicleLeftTime(null);
        vehicle.setSpot(spot);
        vehicleRepository.save(vehicle);
    }

    /**
     * getting the vehicle by using vehicle number
     * @return vehicle if present in database
     */
    public Vehicle findByVehicleNumber(String vehicleNumber) {
        Optional<Vehicle> vehicle = vehicleRepository.findVehicleByVehicleNumber(vehicleNumber);
        if (vehicle.isPresent()) {
            return vehicle.get();
        }
        throw new ParkingLotException("Vehicle not found");
    }

    /**
     * check whether the vehicle object present in the vehicle table already or not
     */
    public Vehicle checkVehicleNumber(String vehicleNumber) {
        Optional<Vehicle> vehicle = vehicleRepository.findVehicleByVehicleNumber(vehicleNumber);
        return vehicle.orElse(null);
    }
}
