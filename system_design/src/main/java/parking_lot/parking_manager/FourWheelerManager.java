package parking_lot.parking_manager;

import parking_lot.parking_spots.FourWheelerSpot;
import parking_lot.parking_spots.ParkingSpot;

import java.util.List;
import java.util.stream.Collectors;

public class FourWheelerManager extends ParkingManager {
    public FourWheelerManager(List<ParkingSpot> parkingSpotList) {
        super(parkingSpotList.stream()
                .filter(spot -> spot instanceof FourWheelerSpot)
                .collect(Collectors.toList()));
    }
}