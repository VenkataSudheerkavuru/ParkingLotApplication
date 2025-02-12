package com.example.parkinglotmanagement.service;


import com.example.parkinglotmanagement.dto.ParkingLotDto;
import com.example.parkinglotmanagement.dto.VehicleDto;
import com.example.parkinglotmanagement.entities.ParkingLot;
import com.example.parkinglotmanagement.repository.ParkingLotRepository;
import org.springframework.stereotype.Service;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {

    private final ParkingLotRepository parkingLotRepository;
    private final LevelService levelService;

    ParkingLotServiceImpl(ParkingLotRepository parkingLotRepository,LevelService levelService) {
        this.parkingLotRepository = parkingLotRepository;
        this.levelService = levelService;
    }

    @Override
    public void createParkingLot(ParkingLotDto parkingLotDto) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setParkingLotName(parkingLotDto.getParkingLotName());
        parkingLot.setTotalLevels(parkingLotDto.getNumberOfLevels());
        ParkingLot savedParkingLot = parkingLotRepository.save(parkingLot);
        levelService.addLelesToParkingLot(savedParkingLot.getParkingLotId(),parkingLotDto.getNumberOfLevels());
    }

    @Override
    public void parkVehicle(Long parkingLotId, VehicleDto vehicleDto) {
    }

    @Override
    public void leaveParking(Long parkingLotId, String vehicleNumber) {

    }


}
