package com.example.parkinglotmanagement.controller;

import com.example.parkinglotmanagement.dto.*;
import com.example.parkinglotmanagement.service.ParkingLotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static com.example.parkinglotmanagement.constants.AppConstants.*;
import static com.example.parkinglotmanagement.constants.URLConstants.*;

/**
 * controller class
 */
@RestController
@RequestMapping(BASEURL)
public class ParkingLotController {


    private final ParkingLotService parkingLotService;

    ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    /**
     * Creating a parking lot
     * @param parkingLotDto contains number of levels and lot name
     */
    @PostMapping(CREATE_PARKING_LOT)
    public ResponseEntity<CreateParkingLotResponse> createParkingLot(@RequestBody ParkingLotDto parkingLotDto) {
        parkingLotService.createParkingLot(parkingLotDto);
        CreateParkingLotResponse createParkingLotResponse = new CreateParkingLotResponse(PARKING_LOT_CREATED);
        return new ResponseEntity<>(createParkingLotResponse, HttpStatus.CREATED);
    }

    /**
     * Parking vehicle
     * @param parkingLotId which parking lot the vehicle want to park
     * @param vehicleDto vehicle information
     */
    @PostMapping(LOT_ID_PARK_VEHICLE)
    public ResponseEntity<ParkingResponse> parkVehicle(@PathVariable Long parkingLotId, @RequestBody VehicleDto vehicleDto) {
        parkingLotService.parkVehicle(parkingLotId, vehicleDto);
        ParkingResponse parkingResponse = new ParkingResponse(PARKING_SUCCESSFUL);
        return new ResponseEntity<>(parkingResponse, HttpStatus.OK);
    }

    /**
     * leaving the parking
     * @param vehicleNumber of vehicle that want to leave parking
     */
    @PostMapping(LEAVE_PARKING_VEHICLE_NUMBER)
    public ResponseEntity<LeavingResponse> leaveParking(@PathVariable String vehicleNumber) {
        Double parkingFee=parkingLotService.leaveParking(vehicleNumber);
        LeavingResponse leavingResponse = new LeavingResponse(formatLeaveParkingResponse(parkingFee));
        return new ResponseEntity<>(leavingResponse, HttpStatus.OK);
    }

    /**
     * Getting all parking spots
     */
    @GetMapping(GET_ALL_SPOTS)
    public ResponseEntity<List<SpotDto>> getAllParkingSpots(@PathVariable Long parkingLotId) {
        List<SpotDto> spots = parkingLotService.getAllParkingSpots(parkingLotId);
        return new ResponseEntity<>(spots, HttpStatus.OK);
    }

}
