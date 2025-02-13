package com.example.parkinglotmanagement.dao;

import com.example.parkinglotmanagement.dto.VehicleDto;
import com.example.parkinglotmanagement.entities.Level;
import com.example.parkinglotmanagement.entities.Spot;
import com.example.parkinglotmanagement.repository.SpotRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class SpotDao {
    private final SpotRepository spotRepository;
    public SpotDao(SpotRepository spotRepository) {
        this.spotRepository = spotRepository;
    }

    public void addSpotToLevel(Level level, String vehicleType, Spot spot, int i) {
        spot.setSpotNumber(i);
        spot.setVehicleType(vehicleType);
        spot.setLevel(level);
        spot.setAvailable(true);
        spotRepository.save(spot);
    }

    public Optional<Spot> findAvailbleSpot(Long levelId, String vehicleType) {
        return spotRepository.findSpotByLevelAndVehicleTypeAndAvailable(levelId,vehicleType);
    }

    public void parkVehicle(Spot spot, VehicleDto vehicleDto) {
        spot.setAvailable(false);
        spot.setEnteredTime(LocalDateTime.now());
        spot.setVehicleType(vehicleDto.getVehicleType());
        spotRepository.save(spot);
    }
}
