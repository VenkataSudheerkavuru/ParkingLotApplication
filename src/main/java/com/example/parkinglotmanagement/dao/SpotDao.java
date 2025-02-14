package com.example.parkinglotmanagement.dao;

import com.example.parkinglotmanagement.dto.VehicleDto;
import com.example.parkinglotmanagement.entities.Level;
import com.example.parkinglotmanagement.entities.Spot;
import com.example.parkinglotmanagement.entities.Vehicle;
import com.example.parkinglotmanagement.repository.SpotRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Dao class for spot class
 */
@Component
public class SpotDao {
    private final SpotRepository spotRepository;

    public SpotDao(SpotRepository spotRepository) {
        this.spotRepository = spotRepository;
    }

    /**
     * save the spot in db and making the spot available
     * @param level which level we want to add spots
     * @param vehicleType type of vehicle
     * @param i spot number
     */
    public void addSpotToLevel(Level level, String vehicleType, Spot spot, int i) {
        spot.setSpotNumber(i);
        spot.setVehicleType(vehicleType);
        spot.setLevel(level);
        spot.setAvailable(true);
        spotRepository.save(spot);
    }

    /**
     * finds the available spot in the specific level with specific type
     * @return available spot if not occupied by some vehicle
     */
    public Spot findAvailbleSpot(Long levelId, String vehicleType) {
        List<Spot> spotList = spotRepository.findSpotByLevelAndVehicleTypeAndAvailable(levelId, vehicleType);
        if (spotList.isEmpty()) {
            return null;
        }
        return spotList.stream().findFirst().get();
    }

    /**
     * parking the vehicle in the available spot by saving it in the database
     */
    public void parkVehicle(Spot spot, VehicleDto vehicleDto, Vehicle vehicle) {
        spot.setAvailable(false);
        spot.setEnteredTime(LocalDateTime.now());
        spot.setVehicleType(vehicleDto.getVehicleType());
        spot.setVehicle(vehicle);
        spotRepository.save(spot);
    }

    /**
     * making the spot available
     */
    public void makeSpotAvailable(Spot spot) {
        spot.setAvailable(true);
        spot.setEnteredTime(null);
        spot.setVehicle(null);
        spotRepository.save(spot);
    }

    /**
     * getting all spots by level id
     */
    public List<Spot> getSpotsByLevelId(Long levelId) {
        return spotRepository.findSpotsByLevel_LevelId(levelId);
    }
}
