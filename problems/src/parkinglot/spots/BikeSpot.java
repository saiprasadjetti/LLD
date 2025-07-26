package parkinglot.spots;

import parkinglot.vehicle.Vehicle;
import parkinglot.vehicle.VehicleType;

public class BikeSpot extends ParkingSpot{

    public BikeSpot(String spotId) {
        super(spotId);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        if(vehicle.getType().equals(VehicleType.BIKE)){
            return true;
        }
        return false;
    }


}
