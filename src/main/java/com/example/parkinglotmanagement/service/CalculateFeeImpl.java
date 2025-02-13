package com.example.parkinglotmanagement.service;

import com.example.parkinglotmanagement.constants.ParkingFee;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class CalculateFeeImpl implements CalculateFee {

    @Override
    public Double calculateParkingFee(String vehicleType, LocalDateTime enteredTime) {
        long minutesParked= Duration.between(enteredTime, LocalDateTime.now()).toMinutes();
        return minutesParked* getParkingFee(vehicleType);
    }

    private Double getParkingFee(String vehicleType) {
        return switch (vehicleType) {
            case "CAR" -> ParkingFee.valueOf(ParkingFee.CAR.name()).getParkingFee();
            case "TRUCK" -> ParkingFee.valueOf(ParkingFee.TRUCK.name()).getParkingFee();
            case "BIKE" -> ParkingFee.valueOf(ParkingFee.BIKE.name()).getParkingFee();
            default -> 1.0;
        };
    }
}
