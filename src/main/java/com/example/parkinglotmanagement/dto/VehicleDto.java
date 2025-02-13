package com.example.parkinglotmanagement.dto;
import com.example.parkinglotmanagement.entities.Spot;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class VehicleDto {

    private  String vehicleNumber;

    private String vehicleType;
}
