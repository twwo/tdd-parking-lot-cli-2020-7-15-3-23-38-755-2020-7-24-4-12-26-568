package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingManagerTest {
    @Test
    void should_specify_parkingboy_park_the_car_when_park_given_car() {
        //given
        ParkingManager parkingManager = new ParkingManager(new ParkingBoy(new ParkingLot(1)));

        //when
        CarTicket CarTicket = (CarTicket) parkingManager.park(new Car()).getResult();

        //then
        assertNotNull(CarTicket);
    }

    @Test
    void should_park_as_parkingboy_when_park_given_car() {
        //given
        ParkingManager parkingManager = new ParkingManager(new ParkingLot(1));

        //when
        CarTicket CarTicket = (CarTicket) parkingManager.park(new Car()).getResult();

        //then
        assertNotNull(CarTicket);
    }
}
