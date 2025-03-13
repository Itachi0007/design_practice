package parking_lot;

import parking_lot.parking_spots.FourWheelerSpot;
import parking_lot.parking_spots.ParkingSpot;
import parking_lot.parking_spots.TwoWheelerSpot;

import java.util.ArrayList;
import java.util.List;

public class ParkingSystemDriver {
    public static void main(String[] args) {
        try {
            // We have to specify the parking lot with a list of parking spots.
            List<ParkingSpot> parkingSpots = new ArrayList<>();
            parkingSpots.add(new FourWheelerSpot());
            parkingSpots.add(new FourWheelerSpot());
            parkingSpots.add(new TwoWheelerSpot());
            parkingSpots.add(new TwoWheelerSpot());

            // Created new parking lot with above parking spot lists
            ParkingLot parkingLot = new ParkingLot(parkingSpots);

            // Simulate a Two-Wheeler Entering
            System.out.println("\n🚲 A Two-Wheeler is Entering...");
            ParkingTicket twoWheelerTicket = parkingLot.collectTicket(VehicleType.TWO_WHEELER);
            System.out.println("🎫 Ticket Issued: " + twoWheelerTicket);

            // Simulate a Four-Wheeler Entering
            System.out.println("\n🚗 A Four-Wheeler is Entering...");
            ParkingTicket fourWheelerTicket = parkingLot.collectTicket(VehicleType.FOUR_WHEELER);
            System.out.println("🎫 Ticket Issued: " + fourWheelerTicket);

            Thread.sleep(3000);

            // Simulate Exit & Payment
            System.out.println("\n💨 Four-Wheeler is Exiting...");
            parkingLot.payParkingFee(fourWheelerTicket);

            Thread.sleep(1500);

            System.out.println("\n💨 Two-Wheeler is Exiting...");
            parkingLot.payParkingFee(twoWheelerTicket);
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}