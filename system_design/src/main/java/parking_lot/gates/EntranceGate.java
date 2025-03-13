package parking_lot.gates;

import parking_lot.ParkingTicket;
import parking_lot.VehicleType;
import parking_lot.parking_manager.ParkingManager;
import parking_lot.parking_manager.ParkingManagerFactory;

public class EntranceGate {
    public ParkingTicket collectTicket(VehicleType vehicleType, ParkingManagerFactory managerFactory) throws Exception {
        ParkingManager parkingManager = managerFactory.getManager(vehicleType);
        return parkingManager.parkMyVehicle(vehicleType);
    }
}

/*
public class EntranceGate {
    private ParkingManager parkingManager;

    public ParkingTicket collectTicket(VehicleType vehicleType) throws Exception {
        // ❌Every time collectTicket() is called, a new instance of the manager is created,
        // which might lead to unnecessary object creation and issues when app sclaes

        // this.parkingManager = ParkingManagerFactory.getManager(vehicleType);
        // 👆 that "this" points to a specific instance of that class.

        return parkingManager.parkMyVehicle(vehicleType);
    }
}
 */

