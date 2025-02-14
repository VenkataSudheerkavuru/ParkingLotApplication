package com.example.parkinglotmanagement.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Spot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long spotId;

    private int spotNumber;

    private String vehicleType;

    private boolean isAvailable;

    private  LocalDateTime enteredTime;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;
   
}
