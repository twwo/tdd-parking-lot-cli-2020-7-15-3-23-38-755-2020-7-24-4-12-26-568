package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SuperSmartParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperSmartParkingBoyTest {
    @Test
    void should_add_car_into_parkinglot_has_larger_rate_when_park_by_supersmartparkingboy_given_car() {
        //given
        ParkingLot parkingLotWith5Room = new ParkingLot(5);
        parkingLotWith5Room.setName("parkingLotWith5Room");
        ParkingLot parkingLotWith10Room = new ParkingLot(10);
        parkingLotWith10Room.setName("parkingLotWith10Room");
        ParkingLot parkingLotWith15Room = new ParkingLot(15);
        parkingLotWith15Room.setName("parkingLotWith15Room");
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(
                Arrays.asList(parkingLotWith5Room, parkingLotWith10Room, parkingLotWith15Room)
        );
        StringBuilder maxRoomParkingLotList = new StringBuilder();

        //when
        for (int i = 0; i < 10; i++) {
            superSmartParkingBoy.park(new Car());
            maxRoomParkingLotList.append(superSmartParkingBoy.getMaxRoomParkingLot().toString());
        }

        //then
        assertEquals("", maxRoomParkingLotList.toString());

    }
}
