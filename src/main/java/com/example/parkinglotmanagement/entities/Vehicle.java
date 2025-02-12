package com.example.parkinglotmanagement.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;

    private  String vehicleNumber;

    private String vehicleType;

    @OneToOne
    @JoinColumn(name = "spot_id")
    private Spot spot;
}
