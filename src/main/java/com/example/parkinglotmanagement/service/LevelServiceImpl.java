package com.example.parkinglotmanagement.service;

import com.example.parkinglotmanagement.dao.LevelDao;
import com.example.parkinglotmanagement.dto.SpotDto;
import com.example.parkinglotmanagement.dto.VehicleDto;
import com.example.parkinglotmanagement.entities.Level;
import com.example.parkinglotmanagement.entities.ParkingLot;
import com.example.parkinglotmanagement.entities.Spot;
import com.example.parkinglotmanagement.exception.ParkingLotException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LevelServiceImpl implements LevelService {

    private final LevelDao levelDao;
    private final SpotService spotService;
    public LevelServiceImpl(LevelDao levelDao,
                            SpotService spotService) {
        this.levelDao = levelDao;
        this.spotService = spotService;
    }

    @Override
    public void addSpotsToLevels(Long parkingLotId, SpotDto spotDto) {
        Map<String,Integer> spotsPerVehicle = spotDto.getSpotsPerVehicle();
        List<Level> levels = levelDao.getLevelsByParkingLotId(parkingLotId);
        for(Level level : levels) {
            spotService.addSpotsToLevels(level,spotsPerVehicle);
        }
    }

    @Override
    public void addLelesToParkingLot(ParkingLot parkingLot, int numberOfLevels) {
        for(int i = 1; i <= numberOfLevels; i++) {
            Level level = new Level();
            levelDao.saveLevel(parkingLot, level, i);
        }
    }

    @Override
    public void parkVehicleAtLevel(Long parkingLotId, VehicleDto vehicleDto) {
        List<Level> levels = levelDao.getLevelsByParkingLotId(parkingLotId);
        String vehicleType = vehicleDto.getVehicleType();
        for(Level level : levels) {
            Spot availableSpot = spotService.findAvailbleSpot(level,vehicleType);
            if(availableSpot!=null) {
                spotService.parkVehicle(availableSpot,vehicleDto);
                return;
            }
        }
        throw new ParkingLotException("No available Spot found for the vehicle type " + vehicleType);
    }

    @Override
    public Double leaveParking(String vehicleNumber, CalculateFee calculateFee) {
        return spotService.leaveParking(vehicleNumber,calculateFee);
    }
}
