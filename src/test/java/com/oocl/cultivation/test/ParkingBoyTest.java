package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingBoyTest {

    @Test
    void should_return_ticket_when_park_by_parkingboy_given_car() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();

        //when
        CarTicket ticket = (CarTicket) parkingBoy.park(car).getResult();

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_right_car_when_fetch_by_parkingboy_given_car_ticket() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        CarTicket ticket = (CarTicket) parkingBoy.park(car).getResult();

        //when
        Car fetchedCar = (Car) parkingBoy.fetch(ticket).getResult();

        //then
        assertNotNull(ticket);
        assertEquals(car, fetchedCar);
    }

    @Test
    void should_return_right_car_when_fetch_by_parkingboy_given_right_ticket() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        CarTicket ticketOfCar1 = (CarTicket) parkingBoy.park(car1).getResult();
        CarTicket ticketOfCar2 = (CarTicket) parkingBoy.park(car2).getResult();

        //when
        Car fetchedCar1 = (Car) parkingBoy.fetch(ticketOfCar1).getResult();
        Car fetchedCar2 = (Car) parkingBoy.fetch(ticketOfCar2).getResult();

        //then
        assertEquals(car1, fetchedCar1);
        assertEquals(car2, fetchedCar2);
    }

    @Test
    void should_return_wrong_message_when_fetch_by_parkingboy_given_wrong_ticket() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.park(car);

        //when
        String wrongMessage = parkingBoy.fetch(new CarTicket()).getMessage();

        //then
        assertEquals(FetchOrParkMessage.UNRECOGNIZED_TICKET.toString(), wrongMessage);
    }

    @Test
    void should_return_wrong_message_when_fetch_by_parkingboy_given_no_ticket() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.park(car);

        //when
        String wrongMessage = parkingBoy.fetch(null).getMessage();

        //then
        assertEquals(FetchOrParkMessage.NO_TICKET.toString(), wrongMessage);
    }

    @Test
    void should_return_wrong_message_when_fetch_by_parkingboy_given_expired_ticket() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        CarTicket ticket = (CarTicket) parkingBoy.park(car).getResult();

        //when
        parkingBoy.fetch(ticket);
        String wrongMessage = parkingBoy.fetch(ticket).getMessage();


        //then
        assertEquals(FetchOrParkMessage.UNRECOGNIZED_TICKET.toString(), wrongMessage);
    }

    @Test
    void should_return_wrong_message_when_park_by_parkingboy_and_parkinglot_is_full_given_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        parkingBoy.park(new Car());

        //when
        String wrongMessage = parkingBoy.park(new Car()).getMessage();

        //then
        assertEquals(FetchOrParkMessage.NO_PARKING_POSITION.toString(), wrongMessage);
    }

    @Test
    void should_park_car_to_second_parkinglot_when_first_parkinglot_is_full_given_car() {
        //given
        ParkingLot parkingLotWith1Room = new ParkingLot(1);
        ParkingLot parkingLot2With2Room = new ParkingLot(2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotWith1Room, parkingLot2With2Room);

        //when
        for (int i = 0; i < 5; i++) {
            parkingBoy.park(new Car());
        }

        //then
        assertNotEquals(5, parkingLot1.getNowRemainRoom());
        assertNotEquals(0, parkingLot2.getNowRemainRoom());
    }
}
