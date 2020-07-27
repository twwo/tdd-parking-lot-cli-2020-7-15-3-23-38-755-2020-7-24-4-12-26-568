package com.oocl.cultivation;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(ParkingLot...parkingLots) {
        super(parkingLots);
    }

    @Override
    public ReturnResult park(Car car) {
        ReturnResult returnResult = new ReturnResult();
        returnResult.setMessage(FetchOrParkMessage.NO_PARKING_POSITION.toString());
        ParkingLot maxRemainRoomParkingLot = getMaxRemainRoomParkingLot();
        if (!maxRemainRoomParkingLot.isParkingLotFull()) {
            returnResult = maxRemainRoomParkingLot.park(car);
        }
        return returnResult;
    }

    public ParkingLot getMaxRemainRoomParkingLot() {
        ParkingLot maxRoomParkingLot = super.getParkingLots().get(0);
        for (ParkingLot parkingLot : super.getParkingLots()) {
            if (parkingLot.getNowRemainRoom() > maxRoomParkingLot.getNowRemainRoom()) {
                maxRoomParkingLot = parkingLot;
            }
        }
        return maxRoomParkingLot;
    }
}
