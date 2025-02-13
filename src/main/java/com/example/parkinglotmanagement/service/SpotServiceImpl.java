package com.example.parkinglotmanagement.service;

import com.example.parkinglotmanagement.dao.SpotDao;
import com.example.parkinglotmanagement.dto.VehicleDto;
import com.example.parkinglotmanagement.entities.Level;
import com.example.parkinglotmanagement.entities.Spot;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Optional;

@Service
public class SpotServiceImpl implements SpotService {

    private final SpotDao spotDao;
    private final VehicleService vehicleService;

    public SpotServiceImpl(SpotDao spotDao, VehicleService vehicleService) {
        this.spotDao = spotDao;
        this.vehicleService = vehicleService;
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
    public Optional<Spot> findAvailbleSpot(Level level, String vehicleType) {
        return spotDao.findAvailbleSpot(level.getLevelId(),vehicleType);
    }

    @Override
    public void parkVehicle(Spot spot, VehicleDto vehicleDto) {
        spotDao.parkVehicle(spot,vehicleDto);
        vehicleService.saveVehicle(spot,vehicleDto);
    }
}
