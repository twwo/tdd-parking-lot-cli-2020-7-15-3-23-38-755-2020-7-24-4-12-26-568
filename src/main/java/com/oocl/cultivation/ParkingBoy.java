package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingBoy implements Parkable{
    private List<ParkingLot> parkingLots;

    public ParkingBoy() {
        parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
    }

    public ParkingBoy(ParkingLot... parkingLots) {
        this.parkingLots = Arrays.asList(parkingLots);
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    @Override
    public ReturnResult park(Car car) {
        ReturnResult returnResult = new ReturnResult();
        returnResult.setMessage(FetchOrParkMessage.NO_PARKING_POSITION.toString());
        for (ParkingLot parkingLot : parkingLots) {
            if (!parkingLot.isParkingLotFull()) {
                returnResult = parkingLot.park(car);
                break;
            }
        }
        return returnResult;
    }

    @Override
    public ReturnResult fetch(CarTicket ticket) {
        ReturnResult returnResult = new ReturnResult();
        if (ticket == null) {
            returnResult.setMessage(FetchOrParkMessage.NO_TICKET.toString());
        } else {
            returnResult.setMessage(FetchOrParkMessage.UNRECOGNIZED_TICKET.toString());
            for (ParkingLot parkingLot : parkingLots) {
                if (parkingLot.isTicketValid(ticket)) {
                    returnResult = parkingLot.fetch(ticket);
                    break;
                }
            }
        }
        return returnResult;
    }

    @Override
    public boolean isFull() {
        for (ParkingLot parkingLot : parkingLots) {
            if (!parkingLot.isParkingLotFull()) {
                return false;
            }
        }
        return true;
    }
}
