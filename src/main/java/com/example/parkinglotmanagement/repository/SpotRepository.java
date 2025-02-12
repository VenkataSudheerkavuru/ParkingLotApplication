package com.example.parkinglotmanagement.repository;

import com.example.parkinglotmanagement.entities.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpotRepository extends JpaRepository<Spot, Long> {
}
