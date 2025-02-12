package com.example.parkinglotmanagement.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class ParkingLot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parkingLotId; //1,2,3

    private String parkingLotName;

    private int totalLevels;

}
