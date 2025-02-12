package com.example.parkinglotmanagement.service;

import com.example.parkinglotmanagement.dto.SpotDto;

public interface LevelService {
    void addSpotsToLevel(long levelId, SpotDto spotDto);

    void addLelesToParkingLot(Long parkingLotId, int numberOfLevels);
}
