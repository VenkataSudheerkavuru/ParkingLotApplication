package com.example.parkinglotmanagement.service;

import com.example.parkinglotmanagement.dao.VehicleDao;
import com.example.parkinglotmanagement.dto.VehicleDto;
import com.example.parkinglotmanagement.entities.Spot;
import com.example.parkinglotmanagement.entities.Vehicle;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleDao vehicleDao;
    public VehicleServiceImpl(VehicleDao vehicleDao) {
        this.vehicleDao = vehicleDao;
    }

    /**
     * saving vehicle in database
     */
    @Override
    public Vehicle saveVehicle(Spot spot, VehicleDto vehicleDto, Vehicle vehicle) {
        return vehicleDao.saveVehicle(spot,vehicleDto,vehicle);
    }

    /**
     * leave parking
     */
    @Override
    public Vehicle leaveParking(String vehicleNumber) {
        Vehicle vehicle = vehicleDao.findByVehicleNumber(vehicleNumber);
        vehicleDao.saveVehicle(vehicle);
        return vehicle;
    }

    /**
     * check whether the vehicle object present in the vehicle table already or not
     */
    @Override
    public Vehicle checkVehicleNumber(VehicleDto vehicleDto) {
        return vehicleDao.checkVehicleNumber(vehicleDto.getVehicleNumber());
    }
}
