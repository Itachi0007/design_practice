package parking_lot;

import parking_lot.parking_spots.ParkingSpot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParkingTicket {
    private Long id;
    private LocalDateTime createdAt;
    private ParkingSpot parkingSpot;
    private Double rate;

    public ParkingTicket(ParkingSpot parkingSpot) {
        this.createdAt = LocalDateTime.now();
        this.parkingSpot = parkingSpot;
        this.id = (long) (Math.random()*100);

        switch (parkingSpot.getVehicleType()) {
            case TWO_WHEELER -> this.rate = 20.0;
            case FOUR_WHEELER -> this.rate = 50.0;
        }
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "ParkingTicket{" +
                "id=" + id +
                ", createdAt=" + createdAt.format(DateTimeFormatter.ISO_DATE) +
                ", parkingSpotType=" + parkingSpot.getVehicleType()+
                ", base rate=" + rate +
                '}';
    }
}
