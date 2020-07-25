package com.oocl.cultivation;

import java.util.List;

public class SuperSmartParkingBoy extends SmartParkingBoy{
    public SuperSmartParkingBoy() {
        super.setMaxRoomParkingLot(getMaxRemainRoomParkingLot());
    }

    public SuperSmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
        super.setMaxRoomParkingLot(getMaxRemainRoomParkingLot());
    }

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        super.setMaxRoomParkingLot(getMaxRemainRoomParkingLot());
    }

    @Override
    public ParkingLot getMaxRemainRoomParkingLot() {
        return super.getMaxRemainRoomParkingLot();
    }
}
