package parkinglot;

import parkinglot.spots.ParkingSpot;
import parkinglot.vehicle.Vehicle;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class ParkingFloor {
    private final int floorNumber;
    private final List<ParkingSpot> parkingSpots;

    public ParkingFloor(int floorNumber, List<ParkingSpot> parkingSpots) {
        this.floorNumber = floorNumber;
        this.parkingSpots = parkingSpots;
    }

    public synchronized Optional<ParkingSpot> getAvailableSpot(Vehicle vehicle){
        return parkingSpots.stream().filter(spot->spot.isAvailable()&&spot.canFitVehicle(vehicle)).findFirst();
    }


}
