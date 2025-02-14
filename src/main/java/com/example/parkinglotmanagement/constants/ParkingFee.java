package com.example.parkinglotmanagement.constants;


import lombok.Getter;

/**
 * Fee based on vehicle type per min
 */
@Getter
public enum ParkingFee {
    CAR(2.0),
    TRUCK(3.0),
    BIKE(1.0);

    private final double parkingFee;

    ParkingFee(double parkingFee) {
        this.parkingFee = parkingFee;
    }
}
