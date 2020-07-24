package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy() {
        parkingLot = new ParkingLot();
    }

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {

    }

    public ReturnResult park(Car car) {
        ReturnResult returnResult = new ReturnResult();
        if (parkingLot.isParkingLotFull()) {
            returnResult.setMessage(FetchOrParkMessage.NO_PARKING_POSITION.toString());
        } else {
            returnResult = parkingLot.park(car);
        }
        return returnResult;
    }

    public ReturnResult fetch(CarTicket ticket) {
        ReturnResult returnResult = new ReturnResult();
        if (ticket == null) {
            returnResult.setMessage(FetchOrParkMessage.NO_TICKET.toString());
        } else if (!parkingLot.isTicketValid(ticket)) {
            returnResult.setMessage(FetchOrParkMessage.UNRECOGNIZED_TICKET.toString());
        } else {
            returnResult = parkingLot.fetch(ticket);
        }
        return returnResult;
    }
}
