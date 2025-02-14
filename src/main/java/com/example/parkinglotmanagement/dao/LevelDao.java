package com.example.parkinglotmanagement.dao;

import com.example.parkinglotmanagement.entities.Level;
import com.example.parkinglotmanagement.entities.ParkingLot;
import com.example.parkinglotmanagement.exception.ParkingLotException;
import com.example.parkinglotmanagement.repository.LevelRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Dao operations for level class
 */
@Component
public class LevelDao {
    private final LevelRepository levelRepository;

    public LevelDao(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    /**
     * Getting levels for a particular lot
     * @param parkingLotId levels of which parking lot
     * @return list of levels
     */
    public List<Level> getLevelsByParkingLotId(Long parkingLotId) {
        List<Level> levelList = levelRepository.findByParkingLotId(parkingLotId);
        if (levelList != null && !levelList.isEmpty()) {
            return levelList;
        }
        throw new ParkingLotException("No parking lot with given id.");
    }

    /**
     * saving level to level database
     * @param parkingLot parkingLot class
     * @param level level class
     * @param i level number
     */
    public void saveLevel(ParkingLot parkingLot, Level level, int i) {
        level.setParkingLot(parkingLot);
        level.setLevelNumber(i);
        levelRepository.save(level);
    }
}
