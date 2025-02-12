package com.example.parkinglotmanagement.repository;

import com.example.parkinglotmanagement.entities.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepository extends JpaRepository<Level, Integer> {
}
