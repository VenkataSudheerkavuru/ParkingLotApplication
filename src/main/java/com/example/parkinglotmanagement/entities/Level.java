package com.example.parkinglotmanagement.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long levelId;

    private int levelNumber;

    @ManyToOne
    @JoinColumn(name = "parking_lot_id")
    private ParkingLot parkingLot;

    @OneToMany(mappedBy = "level", cascade = CascadeType.ALL)
    private List<Spot> spots;
}
