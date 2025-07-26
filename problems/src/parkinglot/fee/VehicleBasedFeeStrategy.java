package parkinglot.fee;

import parkinglot.ParkingTicket;
import parkinglot.vehicle.VehicleType;

import java.util.Map;

public class VehicleBasedFeeStrategy implements FeeStrategy{
    private final Map<VehicleType, Double> hourlyRates = Map.of(
            VehicleType.CAR, 20.0,
            VehicleType.BIKE, 10.0,
            VehicleType.TRUCK, 30.0
    );
    @Override
    public double calculateFee(ParkingTicket parkingTicket) {
       double hour_rate =  hourlyRates.get(parkingTicket.getVehicle().getType());
        long duration = parkingTicket.getExitTimestamp()-parkingTicket.getEntryTimestamp();
        long hours = (duration/1000*60*60)+1;
        return hours * hour_rate;
    }
}
