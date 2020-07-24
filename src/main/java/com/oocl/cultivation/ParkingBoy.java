package com.oocl.cultivation;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy() {
        parkingLot = new ParkingLot();
    }

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ReturnResult park(Car car) {
        return parkingLot.park(car);
    }

    public ReturnResult fetch(CarTicket ticket) {
        return parkingLot.fetch(ticket);
    }
}
