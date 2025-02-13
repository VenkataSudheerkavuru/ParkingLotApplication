package com.example.parkinglotmanagement.service;

import java.time.LocalDateTime;

public interface CalculateFee {
    Double calculateParkingFee(String vehicleType, LocalDateTime enteredTime);
}
