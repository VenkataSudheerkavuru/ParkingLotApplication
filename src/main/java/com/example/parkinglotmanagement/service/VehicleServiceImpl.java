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

    @Override
    public void saveVehicle(Spot spot, VehicleDto vehicleDto) {
        vehicleDao.saveVehicle(spot,vehicleDto);
    }

    @Override
    public Vehicle leaveParking(String vehicleNumber) {
        return vehicleDao.findByVehicleNumber(vehicleNumber);
    }
}
