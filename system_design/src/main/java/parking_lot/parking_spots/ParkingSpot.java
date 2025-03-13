package parking_lot.parking_spots;

import parking_lot.VehicleType;

// If ParkingSpot is abstract (recommended), new ParkingSpot() won’t compile.
public abstract class ParkingSpot {
    private VehicleType vehicleType;
    private boolean isEmpty = true;

    public ParkingSpot(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void parkVehicleOnSpot(VehicleType vehicleType) {
        if (this.vehicleType != vehicleType) {
            throw new IllegalArgumentException("Incorrect vehicle type for this spot");
        }
        System.out.println(vehicleType + " is parked successfully");
        this.isEmpty = false;
    }

    public void removeVehicle() {
        this.isEmpty = true;
        this.vehicleType = null;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
