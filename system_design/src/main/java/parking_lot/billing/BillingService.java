package parking_lot.billing;

import parking_lot.ParkingTicket;

import java.time.Duration;
import java.time.LocalDateTime;

public class BillingService {
    public Double calculateFee(ParkingTicket ticket) {
        Duration timeParked = Duration.between(ticket.getCreatedAt(), LocalDateTime.now());
        System.out.println("Your parking hours:" + timeParked.toMillis()/1000);

        Double fee = timeParked.toMillis()/1000 * ticket.getRate();
        System.out.println("Please pay: $" + fee);
        return fee;
    }
}
