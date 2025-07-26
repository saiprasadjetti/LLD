package parkinglot.spots;

import parkinglot.vehicle.Vehicle;
import parkinglot.vehicle.VehicleType;

public class LargeSpot extends ParkingSpot{

    public LargeSpot(String spotId){
        super(spotId);
    }
    public boolean canFitVehicle(Vehicle vehicle){
       if(vehicle.getType().equals(VehicleType.TRUCK)){
           return true;
       }
       return false;
    }
}
