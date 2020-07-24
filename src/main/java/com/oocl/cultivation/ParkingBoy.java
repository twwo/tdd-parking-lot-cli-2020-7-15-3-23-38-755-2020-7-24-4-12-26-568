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
        if (parkingLot.isTicketValid(ticket)) {
            return parkingLot.fetch(ticket);
        }
        return new ReturnResult(null, FetchOrParkMessage.UNRECOGNIZED_TICKET.toString());
    }
}
