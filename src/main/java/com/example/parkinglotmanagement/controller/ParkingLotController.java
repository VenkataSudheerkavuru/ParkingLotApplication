package com.example.parkinglotmanagement.controller;

import com.example.parkinglotmanagement.dto.ParkingLotDto;
import com.example.parkinglotmanagement.dto.VehicleDto;
import com.example.parkinglotmanagement.service.ParkingLotServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parkingLot")
public class ParkingLotController {

    private final ParkingLotServiceImpl parkingLotService;

    ParkingLotController(ParkingLotServiceImpl parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createParkingLot(@RequestBody ParkingLotDto parkingLotDto) {
        parkingLotService.createParkingLot(parkingLotDto);
        return new ResponseEntity<>("Parking lot created", HttpStatus.CREATED);
    }

    @PostMapping("/{parkingLotId}/parkVehicle")
    public void parkVehicle(@PathVariable Long parkingLotId, @RequestBody VehicleDto vehicleDto) {
        parkingLotService.parkVehicle(parkingLotId, vehicleDto);
    }

    @PostMapping("/{parkingLotId}/leaveParking/{vehicleNumber}")
    public ResponseEntity<String> leaveParking(@PathVariable Long parkingLotId, @PathVariable String vehicleNumber) {
        parkingLotService.leaveParking(parkingLotId, vehicleNumber);
        return new ResponseEntity<>("Parking lot created", HttpStatus.OK);
    }
}
