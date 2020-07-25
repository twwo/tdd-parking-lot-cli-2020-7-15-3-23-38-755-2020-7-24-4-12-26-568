package com.oocl.cultivation;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    private ParkingLot maxRoomParkingLot;

    public ParkingLot getMaxRoomParkingLot() {
        return maxRoomParkingLot;
    }

    public SmartParkingBoy() {
        maxRoomParkingLot = getMaxRemainRoomParkingLot();
    }

    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
        maxRoomParkingLot = getMaxRemainRoomParkingLot();
    }

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        maxRoomParkingLot = getMaxRemainRoomParkingLot();
    }

    @Override
    public ReturnResult park(Car car) {
        ReturnResult returnResult = new ReturnResult();
        returnResult.setMessage(FetchOrParkMessage.NO_PARKING_POSITION.toString());
        if (!getMaxRemainRoomParkingLot().isParkingLotFull()) {
            returnResult = getMaxRemainRoomParkingLot().park(car);
        }
        return returnResult;
    }

    private ParkingLot getMaxRemainRoomParkingLot() {
        maxRoomParkingLot = super.getParkingLots().get(0);
        for (ParkingLot parkingLot : super.getParkingLots()) {
            if (parkingLot.getNowRemainRoom() > maxRoomParkingLot.getNowRemainRoom()) {
                maxRoomParkingLot = parkingLot;
            }
        }
        return maxRoomParkingLot;
    }
}
