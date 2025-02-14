package com.example.parkinglotmanagement.controller;

import com.example.parkinglotmanagement.dto.*;
import com.example.parkinglotmanagement.service.ParkingLotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * controller class
 */
@RestController
@RequestMapping("/api/parkingLot")
public class ParkingLotController {

    private final ParkingLotService parkingLotService;

    ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    /**
     * Creating a parking lot
     * @param parkingLotDto contains number of levels and lot name
     */
    @PostMapping("/create")
    public ResponseEntity<CreateParkingLotResponse> createParkingLot(@RequestBody ParkingLotDto parkingLotDto) {
        parkingLotService.createParkingLot(parkingLotDto);
        CreateParkingLotResponse createParkingLotResponse = new CreateParkingLotResponse("Parking lot created");
        return new ResponseEntity<>(createParkingLotResponse, HttpStatus.CREATED);
    }

    /**
     * Parking vehicle
     * @param parkingLotId which parking lot the vehicle want to park
     * @param vehicleDto vehicle information
     */
    @PostMapping("/{parkingLotId}/parkVehicle")
    public ResponseEntity<ParkingResponse> parkVehicle(@PathVariable Long parkingLotId, @RequestBody VehicleDto vehicleDto) {
        parkingLotService.parkVehicle(parkingLotId, vehicleDto);
        ParkingResponse parkingResponse = new ParkingResponse("Parking Successful");
        return new ResponseEntity<>(parkingResponse, HttpStatus.OK);
    }

    /**
     * leaving the parking
     * @param vehicleNumber of vehicle that want to leave parking
     */
    @PostMapping("/leaveParking/{vehicleNumber}")
    public ResponseEntity<LeavingResponse> leaveParking(@PathVariable String vehicleNumber) {
        Double parkingFee=parkingLotService.leaveParking(vehicleNumber);
        LeavingResponse leavingResponse = new LeavingResponse("Please pay "+ parkingFee +" to leave the parking");
        return new ResponseEntity<>(leavingResponse, HttpStatus.OK);
    }

    @GetMapping("/{parkingLotId}/getAllSpots")
    public ResponseEntity<List<SpotDto>> getAllParkingLots(@PathVariable Long parkingLotId) {
        List<SpotDto> spots = parkingLotService.getAllParkingLots(parkingLotId);
        return new ResponseEntity<>(spots, HttpStatus.OK);
    }
}
