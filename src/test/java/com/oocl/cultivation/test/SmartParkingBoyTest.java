package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SmartParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {
    @Test
    void should_add_car_into_the_most_empty_parkinglot_when_park_by_smartparking_boy_given_car() {
        //given
        ParkingLot parkingLotWith1Room = new ParkingLot(1);
        ParkingLot parkingLotWith2Room = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(
                Arrays.asList(parkingLotWith1Room, parkingLotWith2Room)
        );

        //when
        smartParkingBoy.park(new Car());

        //then
        assertEquals(1, parkingLotWith1Room.getNowRemainRoom());
        assertEquals(1, parkingLotWith2Room.getNowRemainRoom());
    }
}
