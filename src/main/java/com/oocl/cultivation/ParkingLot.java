package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    Map<CarTicket, Car> parkingRooms = new HashMap<>();

    public CarTicket park(Car car) {
        if (parkingRooms.size() == 10) {
            return null;
        }
        CarTicket ticket = new CarTicket();
        parkingRooms.put(ticket, car);
        return ticket;
    }

    public Car fetch(CarTicket ticket) {
        Car fetchedCar = parkingRooms.get(ticket);
        parkingRooms.remove(ticket, fetchedCar);
        return fetchedCar;
    }
}
