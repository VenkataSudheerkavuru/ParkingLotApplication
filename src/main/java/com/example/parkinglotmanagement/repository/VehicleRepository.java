package com.example.parkinglotmanagement.repository;

import com.example.parkinglotmanagement.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * vehicle repository interface
 */
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("select v from Vehicle v where v.vehicleNumber=:vehicleNumber")
    Optional<Vehicle> findVehicleByVehicleNumber(@Param("vehicleNumber") String vehicleNumber);
}
