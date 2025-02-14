package com.example.parkinglotmanagement.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;

    private  String vehicleNumber;

    private String vehicleType;

    private LocalDateTime vehicleEnteredTime;

    private LocalDateTime vehicleLeftTime;

    private Boolean isParked;

    @OneToOne
    @JoinColumn(name = "spot_id")
    private Spot spot;

}
