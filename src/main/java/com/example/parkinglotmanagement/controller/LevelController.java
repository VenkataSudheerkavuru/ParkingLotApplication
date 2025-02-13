package com.example.parkinglotmanagement.controller;


import com.example.parkinglotmanagement.dto.SpotDto;
import com.example.parkinglotmanagement.service.LevelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/level")
public class LevelController {

    private final LevelService levelService;

    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }

    @PostMapping("/{parkingLotId}/spots")
    public ResponseEntity<String> addSpotsToLevels(@PathVariable Long parkingLotId,
                                                  @RequestBody SpotDto spotDto) {
        levelService.addSpotsToLevels(parkingLotId,spotDto);
        return new ResponseEntity<>("Spots added to the levels", HttpStatus.OK);    }
}
