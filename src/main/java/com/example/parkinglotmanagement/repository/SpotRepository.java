package com.example.parkinglotmanagement.repository;

import com.example.parkinglotmanagement.entities.Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.parkinglotmanagement.constants.AppConstants.*;

/**
 * spot repository interface
 */
@Repository
public interface SpotRepository extends JpaRepository<Spot, Long> {


    @Query("select s from Spot s where s.level.levelId=:levelId and s.vehicleType=:vehicleType and s.isAvailable = true")
    List<Spot> findSpotByLevelAndVehicleTypeAndAvailable(@Param(LEVEL_ID) Long levelId, @Param(VEHICLE_TYPE) String vehicleType);

    List<Spot> findSpotsByLevel_LevelId(Long levelId);

}
