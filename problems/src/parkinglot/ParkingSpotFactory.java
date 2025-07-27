package parkinglot;

import parkinglot.spots.BikeSpot;
import parkinglot.spots.CompactSpot;
import parkinglot.spots.LargeSpot;
import parkinglot.spots.ParkingSpot;
import parkinglot.vehicle.Vehicle;
import parkinglot.vehicle.VehicleType;

public class ParkingSpotFactory {
    public static ParkingSpot createSpot(VehicleType type, String spoId){
        switch(type){
            case BIKE: return new BikeSpot(spoId);
            case CAR: return new CompactSpot(spoId);
            case TRUCK: return new LargeSpot(spoId);
            default: throw new IllegalArgumentException("unknown type");
        }
    }
}
