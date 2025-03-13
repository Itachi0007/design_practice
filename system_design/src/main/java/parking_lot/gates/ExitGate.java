package parking_lot.gates;

import parking_lot.ParkingTicket;
import parking_lot.billing.BillingService;

public class ExitGate {
    private static BillingService billingService = new BillingService();

    public void payParkingFee(ParkingTicket ticket) {
        billingService.calculateFee(ticket);
        // vacant that spot also
        ticket.getParkingSpot().removeVehicle();
    }
}
