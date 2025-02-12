package com.example.parkinglotmanagement.service;

import com.example.parkinglotmanagement.dto.SpotDto;
import com.example.parkinglotmanagement.entities.Level;
import com.example.parkinglotmanagement.entities.ParkingLot;
import com.example.parkinglotmanagement.repository.LevelRepository;
import com.example.parkinglotmanagement.repository.ParkingLotRepository;
import com.example.parkinglotmanagement.repository.SpotRepository;
import org.springframework.stereotype.Service;

@Service
public class LevelServiceImpl implements LevelService {

    private final LevelRepository levelRepository;
    private final SpotRepository spotRepository;
    private final ParkingLotRepository parkingLotRepository;
    public LevelServiceImpl(LevelRepository levelRepository, SpotRepository spotRepository, ParkingLotRepository parkingLotRepository) {
        this.levelRepository = levelRepository;
        this.spotRepository = spotRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public void addSpotsToLevel(long levelId, SpotDto spotDto) {

    }

    @Override
    public void addLelesToParkingLot(Long parkingLotId, int numberOfLevels) {
        Level level ;
        ParkingLot parkingLot = parkingLotRepository.findById(parkingLotId).get();
        for(int i = 1; i <= numberOfLevels; i++) {
            level = new Level();
            level.setParkingLot(parkingLot);
            level.setLevelNumber(i);
            levelRepository.save(level);
        }
    }
}
