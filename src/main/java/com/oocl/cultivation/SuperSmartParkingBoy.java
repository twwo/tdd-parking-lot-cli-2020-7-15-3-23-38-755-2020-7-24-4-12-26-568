package com.oocl.cultivation;

public class SuperSmartParkingBoy extends ParkingBoy{


    public SuperSmartParkingBoy(ParkingLot...parkingLots) {
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
            if (parkingLot.getRemainRate() > maxRoomParkingLot.getRemainRate()) {
                maxRoomParkingLot = parkingLot;
            }
        }
        return maxRoomParkingLot;
    }
}
