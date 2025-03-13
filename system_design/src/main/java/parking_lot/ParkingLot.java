package parking_lot;

import parking_lot.gates.EntranceGate;
import parking_lot.gates.ExitGate;
import parking_lot.parking_manager.ParkingManagerFactory;
import parking_lot.parking_spots.ParkingSpot;

import java.util.List;

public class ParkingLot {
    public EntranceGate entranceGate;
    public ExitGate exitGate;
    private ParkingManagerFactory parkingManagerFactory = new ParkingManagerFactory();


    public ParkingLot(List<ParkingSpot> allSpots) {
        this.parkingManagerFactory.allParkingSpots = allSpots;
        this.entranceGate = new EntranceGate();
        this.exitGate = new ExitGate();
    }

    public ParkingTicket collectTicket(VehicleType vehicleType) throws Exception {
        return entranceGate.collectTicket(vehicleType, this.parkingManagerFactory);
    }

    public void payParkingFee(ParkingTicket ticket) {
        exitGate.payParkingFee(ticket);
    }
}
