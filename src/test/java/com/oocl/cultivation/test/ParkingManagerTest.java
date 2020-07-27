package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    void should_specify_smartparkingboy_park_the_car_when_park_given_car() {
        //given
        ParkingManager parkingManager = new ParkingManager(new SmartParkingBoy(new ParkingLot(1)));

        //when
        CarTicket CarTicket = (CarTicket) parkingManager.park(new Car()).getResult();

        //then
        assertNotNull(CarTicket);
    }

    @Test
    void should_specify_supersmartparkingboy_park_the_car_when_park_given_car() {
        //given
        ParkingManager parkingManager = new ParkingManager(new SuperSmartParkingBoy(new ParkingLot(1)));

        //when
        CarTicket CarTicket = (CarTicket) parkingManager.park(new Car()).getResult();

        //then
        assertNotNull(CarTicket);
    }

    @Test
    void should_return_wrong_message_when_tell_parkingboy_to_park_the_car_given_no_ticket() {
        //given
        ParkingManager parkingManager = new ParkingManager(new ParkingBoy(new ParkingLot(1)));

        //when
        String wrongMessage = parkingManager.fetch(null).getMessage();

        //then
        assertEquals(FetchOrParkMessage.NO_TICKET.toString(), wrongMessage);
    }

    @Test
    void should_return_wrong_message_when_tell_parkingboy_to_park_the_car_given_wrong_ticket() {
        //given
        ParkingManager parkingManager = new ParkingManager(new ParkingBoy(new ParkingLot(1)));

        //when
        String wrongMessage = parkingManager.fetch(new CarTicket()).getMessage();

        //then
        assertEquals(FetchOrParkMessage.UNRECOGNIZED_TICKET.toString(), wrongMessage);
    }
}
