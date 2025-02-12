package com.example.parkinglotmanagement.controller;


import com.example.parkinglotmanagement.dto.SpotDto;
import com.example.parkinglotmanagement.service.LevelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/level")
public class LevelController {

    private final LevelService levelService;

    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }

    @PostMapping("/{levelId}/spots")
    public ResponseEntity<String> addSpotsToLevel(@PathVariable long levelId,
                                                  @RequestBody SpotDto spotDto) {
        levelService.addSpotsToLevel(levelId,spotDto);
        return new ResponseEntity<>("Spots added to the levels", HttpStatus.OK);    }
}
