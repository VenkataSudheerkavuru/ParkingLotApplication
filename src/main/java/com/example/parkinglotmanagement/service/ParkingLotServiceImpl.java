package com.example.parkinglotmanagement.service;
import com.example.parkinglotmanagement.dao.ParkingLotDao;
import com.example.parkinglotmanagement.dto.ParkingLotDto;
import com.example.parkinglotmanagement.dto.SpotDto;
import com.example.parkinglotmanagement.dto.VehicleDto;
import com.example.parkinglotmanagement.entities.ParkingLot;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Class contains all Parking lot service related functionalities
 */
@Service
public class ParkingLotServiceImpl implements ParkingLotService {

    private final LevelService levelService;
    private final ParkingLotDao parkingLotDao;
    private final CalculateFee calculateFee;

    ParkingLotServiceImpl(LevelService levelService, ParkingLotDao parkingLotDao, CalculateFee calculateFee) {
        this.levelService = levelService;
        this.parkingLotDao = parkingLotDao;
        this.calculateFee = calculateFee;
    }

    /**
     * creates new parking lot with given name and number of levels
     */
    @Override
    public void createParkingLot(ParkingLotDto parkingLotDto) {
        ParkingLot parkingLot = new ParkingLot();
        Map<String,Integer> numberOfSpots = parkingLotDto.getNumberOfSpots();
        String parkingLotName = parkingLotDto.getParkingLotName();
        int numberOfLevels = parkingLotDto.getNumberOfLevels();
        parkingLotDao.checkParkingLotName(parkingLotName);
        ParkingLot savedParkingLot = parkingLotDao.getSavedParkingLot(numberOfLevels, parkingLot, parkingLotName);
        levelService.addLevelsToParkingLot(savedParkingLot, numberOfLevels , numberOfSpots);
    }

    /**
     * parking vehicle , delegating work to level service
     */
    @Override
    public void parkVehicle(Long parkingLotId, VehicleDto vehicleDto) {
        levelService.parkVehicleAtLevel(parkingLotId,vehicleDto);
    }

    /**
     * leaving from parking.
     */
    @Override
    public Double leaveParking(String vehicleNumber) {
        return levelService.leaveParking(vehicleNumber,calculateFee);
    }

    /**
     * Getting all parking Spots
     */
    @Override
    public List<SpotDto> getAllParkingSpots(Long parkingLotId) {
        return levelService.getAllParkingSpots(parkingLotId);
    }


}
