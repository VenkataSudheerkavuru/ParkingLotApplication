package com.example.parkinglotmanagement.dao;

import com.example.parkinglotmanagement.entities.Level;
import com.example.parkinglotmanagement.entities.ParkingLot;
import com.example.parkinglotmanagement.repository.LevelRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LevelDao {
    private final LevelRepository levelRepository;

    public LevelDao(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    public List<Level> getLevelsByParkingLotId(Long parkingLotId) {
        List<Level> levelList = levelRepository.findByParkingLotId(parkingLotId);
        if (levelList != null && !levelList.isEmpty()) {
            return levelList;
        }
        throw new RuntimeException("No parking lot with given id.");
    }

    public void saveLevel(ParkingLot parkingLot, Level level, int i) {
        level.setParkingLot(parkingLot);
        level.setLevelNumber(i);
        levelRepository.save(level);
    }
}
