package parking_lot;

import parking_lot.gates.EntranceGate;
import parking_lot.gates.ExitGate;
import parking_lot.parking_manager.ParkingManagerFactory;
import parking_lot.parking_spots.FourWheelerSpot;
import parking_lot.parking_spots.ParkingSpot;
import parking_lot.parking_spots.TwoWheelerSpot;

import java.util.ArrayList;
import java.util.List;

public class ParkingSystemDriver {
    public static void main(String[] args) {
        try {
            // ✅ Step 1: Create Parking Spots
            List<ParkingSpot> allSpots = new ArrayList<>();
            allSpots.add(new TwoWheelerSpot());
            allSpots.add(new TwoWheelerSpot());
            allSpots.add(new FourWheelerSpot());
            allSpots.add(new FourWheelerSpot());

            // ✅ Step 2: Initialize Factory with Available Spots
            ParkingManagerFactory.allParkingSpots = allSpots;

            // ✅ Step 3: Create Entrance & Exit Gates
            EntranceGate entranceGate = new EntranceGate();
            ExitGate exitGate = new ExitGate();

            // ✅ Step 4: Simulate a Two-Wheeler Entering
            System.out.println("\n🚲 A Two-Wheeler is Entering...");
            ParkingTicket twoWheelerTicket = entranceGate.collectTicket(VehicleType.TWO_WHEELER);
            System.out.println("🎫 Ticket Issued: " + twoWheelerTicket);

            // ✅ Step 5: Simulate a Four-Wheeler Entering
            System.out.println("\n🚗 A Four-Wheeler is Entering...");
            ParkingTicket fourWheelerTicket = entranceGate.collectTicket(VehicleType.FOUR_WHEELER);
            System.out.println("🎫 Ticket Issued: " + fourWheelerTicket);

            Thread.sleep(3000);

            System.out.println("\n💨 Four-Wheeler is Exiting...");
            exitGate.payParkingFee(fourWheelerTicket);

            Thread.sleep(1500);

            // ✅ Step 6: Simulate Exit & Payment
            System.out.println("\n💨 Two-Wheeler is Exiting...");
            exitGate.payParkingFee(twoWheelerTicket);
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}