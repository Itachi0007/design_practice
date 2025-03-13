package parking_lot.parking_spots;

import parking_lot.VehicleType;

public class FourWheelerSpot extends ParkingSpot {
    public FourWheelerSpot() {
        super(VehicleType.FOUR_WHEELER);  // Pass vehicleType to the parent constructor
    }
}

/*
public class FourWheelerSpot extends ParkingSpot {

    private final VehicleType vehicleType = VehicleType.FOUR_WHEELER; ❌Gets shadowed by parent's variable
    private final int price = 100;

    public FourWheelerSpot() {
    }
}


 */