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
        ReturnResult returnResult = new ReturnResult();
        if (ticket == null) {
            returnResult.setMessage(FetchOrParkMessage.NO_TICKET.toString());
        } else if (!parkingLot.isTicketValid(ticket)) {
            returnResult.setMessage(FetchOrParkMessage.UNRECOGNIZED_TICKET.toString());
        }
        returnResult.setResult(parkingLot.fetch(ticket).getResult());
        return returnResult;
    }
}
