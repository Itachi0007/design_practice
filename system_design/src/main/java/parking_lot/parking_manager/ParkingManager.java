package parking_lot.parking_manager;

import parking_lot.ParkingTicket;
import parking_lot.VehicleType;
import parking_lot.exceptions.NoAvailableSpotException;
import parking_lot.parking_spots.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

public abstract class ParkingManager {
    private List<ParkingSpot> parkingSpotList = new ArrayList<>();

    public boolean addSpot(ParkingSpot parkingSpot) {
        return this.parkingSpotList.add(parkingSpot);
    }

    public boolean removeSpot(ParkingSpot parkingSpot) {
        return this.parkingSpotList.remove(parkingSpot);
    }

    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }

    public ParkingManager(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = (parkingSpotList != null) ? parkingSpotList : new ArrayList<>();
    }

    public ParkingTicket parkMyVehicle(VehicleType vehicleType) throws Exception {
        // check if there are any parkings being managed by the manager
        List<ParkingSpot> totalManagedSpots = getParkingSpotList(); // The output depends on the actual instance type of parkingManager.
        if (totalManagedSpots.isEmpty()) {
            throw new NoAvailableSpotException("ERROR: No spots are being managed currently");
        }

        for(ParkingSpot spot : totalManagedSpots) {
            if(spot.isEmpty()) {
                spot.parkVehicleOnSpot(vehicleType);
                return new ParkingTicket(spot);
            }
        }

        throw new NoAvailableSpotException("SORRY: All spots are occupied");
    }
}
