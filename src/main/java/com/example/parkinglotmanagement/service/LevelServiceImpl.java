package com.example.parkinglotmanagement.service;

import com.example.parkinglotmanagement.dao.LevelDao;
import com.example.parkinglotmanagement.dto.SpotDto;
import com.example.parkinglotmanagement.dto.VehicleDto;
import com.example.parkinglotmanagement.entities.Level;
import com.example.parkinglotmanagement.entities.ParkingLot;
import com.example.parkinglotmanagement.entities.Spot;
import com.example.parkinglotmanagement.exception.ParkingLotException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.example.parkinglotmanagement.constants.AppConstants.NO_AVAILABLE_SPOT_FOUND_FOR_THE_VEHICLE_TYPE;

/**
 * Class contains all level service related functionalities
 */
@Service
public class LevelServiceImpl implements LevelService {

    private final LevelDao levelDao;
    private final SpotService spotService;
    public LevelServiceImpl(LevelDao levelDao,
                            SpotService spotService) {
        this.levelDao = levelDao;
        this.spotService = spotService;
    }

    /**
     * creates spots for each level in a parking lot
     */
    @Override
    public void addSpotsToLevels(Long parkingLotId, Map<String, Integer> numberOfSpots) {
        List<Level> levels = levelDao.getLevelsByParkingLotId(parkingLotId);
        for(Level level : levels) {
            spotService.addSpotsToLevels(level,numberOfSpots);
        }
    }

    /**
     * creates levels for a parking lot
     */
    @Override
    public void addLevelsToParkingLot(ParkingLot parkingLot, int numberOfLevels, Map<String, Integer> numberOfSpots) {
        for(int i = 1; i <= numberOfLevels; i++) {
            Level level = new Level();
            levelDao.saveLevel(parkingLot, level, i);
        }
        addSpotsToLevels(parkingLot.getParkingLotId(), numberOfSpots);
    }

    /**
     * Get list of levels for particular parking lot and at each level it checks
     * for the available parking lot. at any point it found available spot it park
     * vehicle and returns
     */
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
        throw new ParkingLotException(NO_AVAILABLE_SPOT_FOUND_FOR_THE_VEHICLE_TYPE + vehicleType);
    }

    /**
     * leaving from parking delegating work to spot service
     */
    @Override
    public Double leaveParking(String vehicleNumber, CalculateFee calculateFee) {
        return spotService.leaveParking(vehicleNumber,calculateFee);
    }

    /**
     * Get all parking spots for each level and convert it to spot dto class and return
     */
    @Override
    public List<SpotDto> getAllParkingSpots(Long parkingLotId) {
        List<Level> levels = levelDao.getLevelsByParkingLotId(parkingLotId);
        List<SpotDto> spotDtos = new ArrayList<>();
        for(Level level : levels) {
            List<SpotDto> spotsInLevel = spotService.getSpotsByLevel(level.getLevelId());
            spotDtos.addAll(spotsInLevel);
        }
        return spotDtos;
    }
}
