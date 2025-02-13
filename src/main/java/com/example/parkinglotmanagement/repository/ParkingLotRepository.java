package com.example.parkinglotmanagement.repository;

import com.example.parkinglotmanagement.entities.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {
    ParkingLot findByParkingLotName(String parkingLotName);
}
