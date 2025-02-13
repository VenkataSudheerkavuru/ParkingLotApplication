package com.example.parkinglotmanagement.constants;

public enum ParkingFee {
    CAR(2.0),
    TRUCK(3.0),
    BIKE(1.0);

    private double parkingFee;

    ParkingFee(double parkingFee) {
        this.parkingFee = parkingFee;
    }
    public double getParkingFee() {
        return parkingFee;
    }
}
