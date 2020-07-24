package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_park_given_car() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();

        //when
        CarTicket ticket = (CarTicket) parkingLot.park(car).getResult();

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_right_car_when_fetch_given_car_ticket() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        CarTicket ticket = (CarTicket) parkingLot.park(car).getResult();

        //when
        Car fetchedCar = (Car) parkingLot.fetch(ticket).getResult();

        //then
        assertNotNull(ticket);
        assertEquals(car, fetchedCar);
    }
}
