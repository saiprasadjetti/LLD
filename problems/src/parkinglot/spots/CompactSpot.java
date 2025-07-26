package parkinglot.spots;

import parkinglot.vehicle.Vehicle;
import parkinglot.vehicle.VehicleType;

public class CompactSpot extends ParkingSpot{


    public CompactSpot(String spotId) {
        super(spotId);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        if(vehicle.getType().equals(VehicleType.CAR)){
            return true;
        }
        return false;
    }
}
