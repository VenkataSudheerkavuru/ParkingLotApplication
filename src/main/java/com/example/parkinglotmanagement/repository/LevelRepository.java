package com.example.parkinglotmanagement.repository;

import com.example.parkinglotmanagement.entities.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * level repository interface
 */
public interface LevelRepository extends JpaRepository<Level, Long> {

    @Query("select l from Level l where l.parkingLot.parkingLotId=:parkingLotId")
    List<Level> findByParkingLotId(@Param("parkingLotId") Long parkingLotId);
}
