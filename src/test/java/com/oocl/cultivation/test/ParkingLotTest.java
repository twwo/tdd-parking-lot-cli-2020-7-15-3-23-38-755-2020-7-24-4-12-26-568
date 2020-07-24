package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_park_given_car() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();

        //when
        CarTicket ticket = parkingLot.park(car);

        //then
        assertNotNull(ticket);
    }
}
