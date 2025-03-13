package parking_lot.parking_spots;

import parking_lot.VehicleType;

public class TwoWheelerSpot extends ParkingSpot {
    public TwoWheelerSpot() {
        super(VehicleType.TWO_WHEELER);  // Pass vehicleType to the parent constructor to avoid shadowing
    }
}


/*
public class TwoWheelerSpot extends ParkingSpot {

    private final VehicleType vehicleType = VehicleType.TWO_WHEELER; ❌It gets shadowed
    private final int price = 50;
}
 */


