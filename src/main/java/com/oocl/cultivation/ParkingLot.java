package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<CarTicket, Car> parkingRooms = new HashMap<>();

    private int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {
        this.capacity = 10;
    }

    public ReturnResult park(Car car) {
        if (parkingRooms.size() == capacity) {
            return null;
        }
        CarTicket ticket = new CarTicket();
        parkingRooms.put(ticket, car);
        ReturnResult returnResult = new ReturnResult(ticket, "success");
        return returnResult;
    }

    public Car fetch(CarTicket ticket) {
        Car fetchedCar = parkingRooms.get(ticket);
        parkingRooms.remove(ticket, fetchedCar);
        return fetchedCar;
    }
}
