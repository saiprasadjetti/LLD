package parkinglot;

import parkinglot.fee.VehicleBasedFeeStrategy;
import parkinglot.spots.BikeSpot;
import parkinglot.spots.CompactSpot;
import parkinglot.spots.LargeSpot;
import parkinglot.spots.ParkingSpot;
import parkinglot.vehicle.*;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotDemo {

    public static void run() throws Exception {

        ParkingLot parkingLot = ParkingLot.getInstance();
        List<ParkingSpot> firstFloorSpots = new ArrayList<>();
        firstFloorSpots.add(new BikeSpot("1"));
        firstFloorSpots.add(new LargeSpot("2"));
        firstFloorSpots.add(new CompactSpot("3"));

        List<ParkingSpot> secondFloorSpots = new ArrayList<>();
        secondFloorSpots.add(new BikeSpot("4"));
        secondFloorSpots.add(new LargeSpot("5"));
        secondFloorSpots.add(new CompactSpot("6"));

        parkingLot.addFloor(new ParkingFloor(1,firstFloorSpots));
        parkingLot.addFloor(new ParkingFloor(2,secondFloorSpots));
        parkingLot.setFeeStrategy(new VehicleBasedFeeStrategy());
        Vehicle bike1 = new Bike("123", VehicleType.BIKE);
        Vehicle car1 = new Car("456", VehicleType.CAR);
        Vehicle truck1 = new Truck("235", VehicleType.TRUCK);
        Vehicle bike2 = new Bike("13423", VehicleType.BIKE);
        Vehicle car2 = new Car("245145", VehicleType.CAR);
        Vehicle truck2 = new Truck("24123435", VehicleType.TRUCK);
        ParkingTicket parkingTicket =  parkingLot.parkVehicle(bike1);
        System.out.println("bike1 is parked successfully with ticket id"+ parkingTicket.getTicketId());
        parkingLot.parkVehicle(bike2);
        parkingLot.parkVehicle(car2);
        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(truck1);
        parkingLot.parkVehicle(truck2);
        parkingLot.unparkVehicle(bike2.getLicenceNumber());
    }
}
