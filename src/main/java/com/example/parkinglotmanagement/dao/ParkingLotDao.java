package com.example.parkinglotmanagement.dao;

import com.example.parkinglotmanagement.entities.ParkingLot;
import com.example.parkinglotmanagement.exception.ParkingLotException;
import com.example.parkinglotmanagement.repository.ParkingLotRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Dao operations for parking lot class
 */
@Component
public class ParkingLotDao {
    private final ParkingLotRepository parkingLotRepository;

    public ParkingLotDao(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    /**
     * checking whether the parking lot name already exists in the database or not
     * @param parkingLotName entered name
     */
    public void checkParkingLotName(String parkingLotName) {
        if (parkingLotRepository.findByParkingLotName(parkingLotName) != null) {
            throw new ParkingLotException("Parking lot name already exists");
        }
    }

    /**
     * saving parking lot to database
     * @return saved parking lot
     */
    public ParkingLot getSavedParkingLot(int numberLevels, ParkingLot parkingLot, String parkingLotName) {
        parkingLot.setParkingLotName(parkingLotName);
        parkingLot.setTotalLevels(numberLevels);
        return parkingLotRepository.save(parkingLot);
    }

}
