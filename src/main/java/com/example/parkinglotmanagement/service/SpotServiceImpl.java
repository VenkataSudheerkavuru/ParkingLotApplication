package com.example.parkinglotmanagement.service;
import com.example.parkinglotmanagement.dao.SpotDao;
import com.example.parkinglotmanagement.dto.VehicleDto;
import com.example.parkinglotmanagement.entities.Level;
import com.example.parkinglotmanagement.entities.Spot;
import com.example.parkinglotmanagement.entities.Vehicle;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * Class contains all Spot service related functionalities
 */
@Service
public class SpotServiceImpl implements SpotService {

    private final SpotDao spotDao;
    private final VehicleService vehicleService;


    public SpotServiceImpl(SpotDao spotDao, VehicleService vehicleService) {
        this.spotDao = spotDao;
        this.vehicleService = vehicleService;
    }

    /**
     * creating spots for each level
     */
    @Override
    public void addSpotsToLevels(Level level, Map<String, Integer> spotsPerVehicle) {
        spotsPerVehicle.forEach((vehicleType, spots) -> {
            for (int i = 1; i <= spots; i++) {
                Spot spot= new Spot();
                spotDao.addSpotToLevel(level, vehicleType, spot, i);
            }
        });
    }

    /**
     * finding available spot to park vehicle
     */
    @Override
    public Spot findAvailbleSpot(Level level, String vehicleType) {
        return spotDao.findAvailbleSpot(level.getLevelId(),vehicleType);
    }

    /**
     * park vehicle in the spot
     * and save the vehicle in the database
     */
    @Override
    public void parkVehicle(Spot spot, VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleService.checkVehicleNumber(vehicleDto);
        spotDao.parkVehicle(spot,vehicleDto);
        vehicleService.saveVehicle(spot,vehicleDto,vehicle);
    }

    /**
     * leave the parking and returning the parking fee
     */
    @Override
    public Double leaveParking(String vehicleNumber, CalculateFee calculateFee) {
        Vehicle vehicle = vehicleService.leaveParking(vehicleNumber);
        Spot spot = vehicle.getSpot();
        spotDao.makeSpotAvailable(spot);
        return calculateFee.calculateParkingFee(vehicle.getVehicleType(),spot.getEnteredTime());
    }
}
