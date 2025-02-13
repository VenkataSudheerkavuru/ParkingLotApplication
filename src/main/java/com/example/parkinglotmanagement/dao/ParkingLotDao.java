package com.example.parkinglotmanagement.dao;

import com.example.parkinglotmanagement.dto.ParkingLotDto;
import com.example.parkinglotmanagement.entities.ParkingLot;
import com.example.parkinglotmanagement.exception.ParkingLotException;
import com.example.parkinglotmanagement.repository.ParkingLotRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ParkingLotDao {
    private final ParkingLotRepository parkingLotRepository;

    public ParkingLotDao(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    public ParkingLot getParkingLotById(Long parkingLotId) {
        Optional<ParkingLot> parkingLot = parkingLotRepository.findById(parkingLotId);
        if(parkingLot.isPresent()){
            return parkingLot.get();
        }else{
            throw new ParkingLotException("Parking lot doesn't exists");
        }
    }

    public void checkParkingLotName(String parkingLotName) {
        if(parkingLotRepository.findByParkingLotName(parkingLotName)!=null) {
            throw new ParkingLotException("Parking lot name already exists");
        };
    }

    public ParkingLot getSavedParkingLot(int numberOflevels, ParkingLot parkingLot, String parkingLotName) {
        parkingLot.setParkingLotName(parkingLotName);
        parkingLot.setTotalLevels(numberOflevels);
        return parkingLotRepository.save(parkingLot);
    }

}
