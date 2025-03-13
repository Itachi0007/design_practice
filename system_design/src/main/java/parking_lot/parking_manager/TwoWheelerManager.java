package parking_lot.parking_manager;

import parking_lot.parking_spots.ParkingSpot;
import parking_lot.parking_spots.TwoWheelerSpot;

import java.util.List;
import java.util.stream.Collectors;

public class TwoWheelerManager extends ParkingManager {
    public TwoWheelerManager(List<ParkingSpot> parkingSpotList) {
        super(parkingSpotList.stream()
                .filter(spot -> spot instanceof TwoWheelerSpot)
                .collect(Collectors.toList()));
    }
}