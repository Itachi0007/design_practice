# 🚗 Parking Management System
The **Parking Management System** is designed to handle vehicle parking efficiently. It supports different vehicle types (Two-Wheeler & Four-Wheeler) and manages parking spots dynamically. The system includes functionality for issuing parking tickets, tracking occupied spots, and calculating parking fees upon exit.

## System Components

### 1. **ParkingSpot (Abstract Class)**
- Represents a generic parking spot.
- Two concrete subclasses:
  - `TwoWheelerSpot` 🚲
  - `FourWheelerSpot` 🚗
- Implements methods to **park** and **remove** vehicles.

### 2. **ParkingManager**
- Manages a list of parking spots.
- Handles vehicle parking and assigns available spots.
- **Subclasses:**
  - `TwoWheelerManager` - Manages only Two-Wheeler spots.
  - `FourWheelerManager` - Manages only Four-Wheeler spots.

### 3. **ParkingManagerFactory**
- Centralized factory to provide appropriate `ParkingManager` based on vehicle type.
- Uses a **global list of parking spots** to manage availability dynamically.

### 4. **EntranceGate**
- Assigns an available parking spot to incoming vehicles.
- Issues a `ParkingTicket` with spot details and entry time.

### 5. **ExitGate** 🏁💨
- Accepts `ParkingTicket` when a vehicle exits.
- Calculates the parking fee based on duration.
- Frees up the occupied parking spot.

### 6. **ParkingTicket** 🎫
- Stores details of the parked vehicle, spot, entry time, and base rate to be charged on exit.

---
## How It Works

1. **Initialization**
- Parking spots (Two-Wheeler & Four-Wheeler) are created.
- `ParkingManagerFactory` stores all available spots.

2. **Vehicle Entry**
- Vehicle arrives at the `EntranceGate`.
- `collectTicket(vehicleType)` is called.
- `ParkingManager` assigns a free spot and returns a `ParkingTicket`.

3. **Vehicle Exit**
- Vehicle arrives at the `ExitGate`.
- `payParkingFee(ticket)` is called.
- Fee is calculated based on time parked.
- Spot is vacated.

## Running the System
Run the `ParkingSystemDriver` class to simulate the entire flow:

```java
public class ParkingSystemDriver {
    public static void main(String[] args) {
        // Initialize parking spots
        List<ParkingSpot> allSpots = new ArrayList<>();
        allSpots.add(new TwoWheelerSpot());
        allSpots.add(new FourWheelerSpot());
        ParkingManagerFactory.allParkingSpots = allSpots;

        EntranceGate entranceGate = new EntranceGate();
        ExitGate exitGate = new ExitGate();

        // Vehicle enters
        ParkingTicket ticket = entranceGate.collectTicket(VehicleType.TWO_WHEELER);

        // Vehicle exits
        exitGate.payParkingFee(ticket);
    }
}
```

## Future Enhancements
-  **Payment Integration** (Cash/Card/UPI)
-  **Multi-Level Parking Management**
-  **Real-Time Spot Availability Display**

🚀 **Happy Parking brothers!** 🚀

