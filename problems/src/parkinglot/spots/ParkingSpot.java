package parkinglot.spots;

import parkinglot.vehicle.Vehicle;
import parkinglot.vehicle.VehicleType;

public abstract class ParkingSpot {
    private final String spotId;
    private boolean isOccupied;
    private Vehicle vehicle;

    public ParkingSpot(String spotId) {
        this.spotId = spotId;
        this.isOccupied = false;
    }
    public synchronized boolean isAvailable(){
        return !isOccupied;
    }
    public synchronized String getSpotId(){
        return spotId;
    }
    public synchronized boolean assignVehicle(Vehicle vehicle){
        if(isOccupied){
            return false;
        }
        this.vehicle =vehicle;
        isOccupied= true;
        return true;
    }
    public synchronized void removeVehicle(){
        this.isOccupied = false;
        this.vehicle = null;
    }
    public abstract boolean canFitVehicle(Vehicle vehicle);
}
