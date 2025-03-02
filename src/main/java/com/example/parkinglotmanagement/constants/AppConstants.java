package com.example.parkinglotmanagement.constants;

public class AppConstants {
    public static final String PARKING_LOT_CREATED = "Parking lot created";
    public static final String PARKING_SUCCESSFUL = "Parking Successful";

    public static final String NO_PARKING_LOT_WITH_GIVEN_ID = "No parking lot with given id.";
    public static final String PARKING_LOT_NAME_ALREADY_EXISTS = "Parking lot name already exists";
    public static final String VEHICLE_NOT_FOUND = "Vehicle not found";
    public static final String PLEASE_VERIFY_VEHICLE_NUMBER = "Please verify vehicle number";

    public static final String PARKING_LOT_ID = "parkingLotId";
    public static final String LEVEL_ID = "levelId";
    public static final String VEHICLE_TYPE = "vehicleType";
    public static final String VEHICLE_NUMBER = "vehicleNumber";

    public static final String CAR = "CAR";
    public static final String TRUCK = "TRUCK";
    public static final String BIKE = "BIKE";

    public static final String NO_AVAILABLE_SPOT_FOUND_FOR_THE_VEHICLE_TYPE = "No available Spot found for the vehicle type ";

    public static String formatLeaveParkingResponse(Double parkingFee) {
        return "Please pay " + parkingFee + " to leave the parking";
    }
}
