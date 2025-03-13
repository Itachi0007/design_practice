package parking_lot.parking_manager;

import parking_lot.VehicleType;
import parking_lot.parking_spots.ParkingSpot;

import java.util.ArrayList;
import java.util.List;


public class ParkingManagerFactory {
    public List<ParkingSpot> allParkingSpots = new ArrayList<>();

    public ParkingManager getManager(VehicleType vehicleType) {
        switch (vehicleType) {
            case FOUR_WHEELER -> {
                return new FourWheelerManager(allParkingSpots);
            }
            case TWO_WHEELER -> {
                return new TwoWheelerManager(allParkingSpots);
            }
            default -> throw new IllegalStateException("Unexpected value: " + vehicleType);
        }
    }
}
