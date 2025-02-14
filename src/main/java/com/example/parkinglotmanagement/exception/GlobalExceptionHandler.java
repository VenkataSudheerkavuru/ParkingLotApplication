package com.example.parkinglotmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Exception class for all types of exceptions
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * ParkingLotException exception handling
     */
    @ExceptionHandler(ParkingLotException.class)
    public ResponseEntity<String> handleParkingLotException(ParkingLotException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    /**
     * If any unhandled exception comes this method handles it
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
