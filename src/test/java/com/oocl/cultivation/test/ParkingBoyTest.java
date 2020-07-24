package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {

    @Test
    void should_return_ticket_when_park_by_parkingboy_given_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();

        //when
        CarTicket ticket = parkingBoy.park(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_right_car_when_fetch_by_parkingboy_given_car_ticket() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        CarTicket ticket = parkingBoy.park(car);

        //when
        Car fetchedCar = parkingBoy.fetch(ticket);

        //then
        assertNotNull(ticket);
        assertEquals(car, fetchedCar);
    }

    @Test
    void should_return_right_car_when_fetch_by_parkingboy_given_right_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        CarTicket ticketOfCar1 = parkingBoy.park(car1);
        CarTicket ticketOfCar2 = parkingBoy.park(car2);

        //when
        Car fetchedCar1 = parkingBoy.fetch(ticketOfCar1);
        Car fetchedCar2 = parkingBoy.fetch(ticketOfCar2);

        //then
        assertEquals(car1, fetchedCar1);
        assertEquals(car2, fetchedCar2);
    }

    @Test
    void should_not_return_car_when_fetch_by_parkingboy_given_wrong_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.park(car);

        //when
        Car wrongTicketFetchedCar = parkingBoy.fetch(new CarTicket());

        //then
        assertNull(wrongTicketFetchedCar);
    }

    @Test
    void should_not_return_car_when_fetch_by_parkingboy_given_no_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.park(car);

        //when
        Car wrongTicketFetchedCar = parkingBoy.fetch(null);

        //then
        assertNull(wrongTicketFetchedCar);
    }

    @Test
    void should_not_return_car_when_fetch_by_parkingboy_given_expired_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        CarTicket ticket = parkingBoy.park(car);

        //when
        Car firstFetchedCar = parkingBoy.fetch(ticket);
        Car secondFetchedCar = parkingBoy.fetch(ticket);
        boolean result = firstFetchedCar.equals(secondFetchedCar);

        //then
        assertFalse(result);
    }
}
