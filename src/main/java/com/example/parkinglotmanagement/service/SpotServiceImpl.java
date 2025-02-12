package com.example.parkinglotmanagement.service;

import com.example.parkinglotmanagement.repository.SpotRepository;
import org.springframework.stereotype.Service;

@Service
public class SpotServiceImpl implements SpotService{

    private final SpotRepository spotRepository;
    public SpotServiceImpl(SpotRepository spotRepository) {
        this.spotRepository = spotRepository;
    }
}
