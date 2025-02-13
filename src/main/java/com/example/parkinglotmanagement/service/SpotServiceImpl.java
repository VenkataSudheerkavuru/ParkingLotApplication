package com.example.parkinglotmanagement.service;

import com.example.parkinglotmanagement.dao.SpotDao;
import com.example.parkinglotmanagement.dao.VehicleDao;
import com.example.parkinglotmanagement.dto.VehicleDto;
import com.example.parkinglotmanagement.entities.Level;
import com.example.parkinglotmanagement.entities.Spot;
import com.example.parkinglotmanagement.entities.Vehicle;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class SpotServiceImpl implements SpotService {

    private final SpotDao spotDao;
    private final VehicleService vehicleService;
    private final VehicleDao vehicleDao;


    public SpotServiceImpl(SpotDao spotDao, VehicleService vehicleService, VehicleDao vehicleDao) {
        this.spotDao = spotDao;
        this.vehicleService = vehicleService;
        this.vehicleDao = vehicleDao;
    }

    @Override
    public void addSpotsToLevels(Level level, Map<String, Integer> spotsPerVehicle) {
        spotsPerVehicle.forEach((vehicleType, spots) -> {
            for (int i = 1; i <= spots; i++) {
                Spot spot= new Spot();
                spotDao.addSpotToLevel(level, vehicleType, spot, i);
            }
        });
    }

    @Override
    public Spot findAvailbleSpot(Level level, String vehicleType) {
        return spotDao.findAvailbleSpot(level.getLevelId(),vehicleType);
    }

    @Override
    public void parkVehicle(Spot spot, VehicleDto vehicleDto) {
        vehicleService.checkVehicleNumber(vehicleDto);
        spotDao.parkVehicle(spot,vehicleDto);
        vehicleService.saveVehicle(spot,vehicleDto);
    }

    @Override
    public Double leaveParking(String vehicleNumber, CalculateFee calculateFee) {
        Vehicle vehicle = vehicleService.leaveParking(vehicleNumber);
        Spot spot = vehicle.getSpot();
        vehicleDao.makeSpotAvailable(spot);
        return calculateFee.calculateParkingFee(vehicle.getVehicleType(),spot.getEnteredTime());
    }
}
