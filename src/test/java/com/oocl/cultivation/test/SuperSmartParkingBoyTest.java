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
        ParkingLot parkingLotWith10Room = new ParkingLot(10);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(
                Arrays.asList(parkingLotWith5Room, parkingLotWith10Room)
        );

        //when
        for (int i = 0; i < 5; i++) {
            superSmartParkingBoy.park(new Car());
        }

        //then
        assertEquals(3, parkingLotWith5Room.getNowRemainRoom());
        assertEquals(7, parkingLotWith10Room.getNowRemainRoom());
    }
}
