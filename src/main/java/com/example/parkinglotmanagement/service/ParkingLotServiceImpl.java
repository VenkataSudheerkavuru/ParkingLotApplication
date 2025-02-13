package com.example.parkinglotmanagement.service;


import com.example.parkinglotmanagement.dao.ParkingLotDao;
import com.example.parkinglotmanagement.dto.ParkingLotDto;
import com.example.parkinglotmanagement.dto.VehicleDto;
import com.example.parkinglotmanagement.entities.ParkingLot;
import com.example.parkinglotmanagement.repository.ParkingLotRepository;
import org.springframework.stereotype.Service;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {

    private final LevelService levelService;
    private final ParkingLotDao parkingLotDao;

    ParkingLotServiceImpl(LevelService levelService, ParkingLotDao parkingLotDao) {
        this.levelService = levelService;
        this.parkingLotDao = parkingLotDao;
    }

    @Override
    public void createParkingLot(ParkingLotDto parkingLotDto) {
        ParkingLot parkingLot = new ParkingLot();
        String parkingLotName = parkingLotDto.getParkingLotName();
        int numberOfLevels = parkingLotDto.getNumberOfLevels();
        parkingLotDao.checkParkingLotName(parkingLotName);
        ParkingLot savedParkingLot = parkingLotDao.getSavedParkingLot(numberOfLevels, parkingLot, parkingLotName);
        levelService.addLelesToParkingLot(savedParkingLot, numberOfLevels);
    }


    @Override
    public void parkVehicle(Long parkingLotId, VehicleDto vehicleDto) {
        levelService.parkVehicleAtLevel(parkingLotId,vehicleDto);
    }

    @Override
    public void leaveParking(Long parkingLotId, String vehicleNumber) {

    }


}
