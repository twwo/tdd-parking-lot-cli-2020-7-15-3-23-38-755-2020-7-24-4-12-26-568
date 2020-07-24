package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    Map<CarTicket, Car> parkingRooms = new HashMap<>();

    public CarTicket park(Car car) {
        CarTicket ticket = new CarTicket();
        parkingRooms.put(ticket, car);
        return ticket;
    }

    public Car fetch(CarTicket ticket) {
        return parkingRooms.get(ticket);
    }
}
