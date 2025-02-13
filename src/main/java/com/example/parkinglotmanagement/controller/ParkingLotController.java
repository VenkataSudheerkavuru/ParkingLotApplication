package com.example.parkinglotmanagement.controller;

import com.example.parkinglotmanagement.dto.ParkingLotDto;
import com.example.parkinglotmanagement.dto.VehicleDto;
import com.example.parkinglotmanagement.service.ParkingLotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parkingLot")
public class ParkingLotController {

    private final ParkingLotService parkingLotService;

    ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createParkingLot(@RequestBody ParkingLotDto parkingLotDto) {
        parkingLotService.createParkingLot(parkingLotDto);
        return new ResponseEntity<>("Parking lot created", HttpStatus.CREATED);
    }

    @PostMapping("/{parkingLotId}/parkVehicle")
    public ResponseEntity<String> parkVehicle(@PathVariable Long parkingLotId, @RequestBody VehicleDto vehicleDto) {
        parkingLotService.parkVehicle(parkingLotId, vehicleDto);
        return new ResponseEntity<>("Parking Successful", HttpStatus.OK);
    }

    @PostMapping("/{parkingLotId}/leaveParking/{vehicleNumber}")
    public ResponseEntity<String> leaveParking(@PathVariable Long parkingLotId, @PathVariable String vehicleNumber) {
        parkingLotService.leaveParking(parkingLotId, vehicleNumber);
        return new ResponseEntity<>("Vehicle Left Parking", HttpStatus.OK);
    }
}
