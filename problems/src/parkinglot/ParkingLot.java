package parkinglot;

import parkinglot.fee.FeeStrategy;
import parkinglot.spots.ParkingSpot;
import parkinglot.vehicle.Vehicle;
import parkinglot.vehicle.VehicleType;

import java.util.*;

public class ParkingLot {

    private static final ParkingLot INSTANCE = new ParkingLot();
    private final List<ParkingFloor> parkingFloorList =new ArrayList<>();
    private final Map<String,ParkingTicket> activeTickets = new HashMap<>();
    private FeeStrategy feeStrategy;

    public synchronized static ParkingLot getInstance(){
        return INSTANCE;
    }

    public void addFloor(ParkingFloor parkingFloor){
        parkingFloorList.add(parkingFloor);
    }

    public void setFeeStrategy(FeeStrategy feeStrategy){
        this.feeStrategy=feeStrategy;
    }

    public synchronized ParkingTicket parkVehicle(Vehicle vehicle) throws Exception{
        for(ParkingFloor floor:parkingFloorList){
            Optional<ParkingSpot> spotOptional= floor.getAvailableSpot(vehicle);
            if(spotOptional.isPresent()){
                ParkingSpot spot = spotOptional.get();
                if(spot.assignVehicle(vehicle)){
                    ParkingTicket parkingTicket = new ParkingTicket(vehicle,spot);
                    activeTickets.put(vehicle.getLicenceNumber(),parkingTicket);
                    return parkingTicket;
                }
            }
        }
        throw new Exception("No avalable spot for"+ vehicle.getType());
    }

    synchronized double unparkVehicle(String licence){
        ParkingTicket ticket = activeTickets.get(licence);
        ticket.getParkingSpot().removeVehicle();
        ticket.setExitTimestamp();
        return feeStrategy.calculateFee(ticket);
    }


}
