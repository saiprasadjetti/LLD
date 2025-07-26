package parkinglot.fee;

import parkinglot.ParkingTicket;

public interface FeeStrategy {
    public double calculateFee(ParkingTicket parkingTicket);
}
