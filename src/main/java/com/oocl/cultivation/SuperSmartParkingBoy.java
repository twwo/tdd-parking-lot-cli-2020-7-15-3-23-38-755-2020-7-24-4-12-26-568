package com.oocl.cultivation;

public class SuperSmartParkingBoy extends ParkingBoy{
    private ParkingLot maxRoomParkingLot;

    public SuperSmartParkingBoy() {
        maxRoomParkingLot = getMaxRemainRoomParkingLot();
    }

    public SuperSmartParkingBoy(ParkingLot...parkingLots) {
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

    public ParkingLot getMaxRemainRoomParkingLot() {
        maxRoomParkingLot = super.getParkingLots().get(0);
        for (ParkingLot parkingLot : super.getParkingLots()) {
            double rate = parkingLot.getRemainRate();
            double maxRate = maxRoomParkingLot.getRemainRate();
            if (parkingLot.getRemainRate() > maxRoomParkingLot.getRemainRate()) {
                maxRoomParkingLot = parkingLot;
            }
        }
        return maxRoomParkingLot;
    }
}
