package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private String name = "defaultParkingLot";
    private Map<CarTicket, Car> parkingRooms = new HashMap<>();
    private int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {
        this.capacity = 10;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ReturnResult park(Car car) {
        if (parkingRooms.size() == capacity) {
            return new ReturnResult(null, FetchOrParkMessage.NO_PARKING_POSITION.toString());
        }
        CarTicket ticket = new CarTicket();
        parkingRooms.put(ticket, car);
        return new ReturnResult(ticket, FetchOrParkMessage.SUCCESS.toString());
    }

    public ReturnResult fetch(CarTicket ticket) {
        Car fetchedCar = parkingRooms.get(ticket);
        parkingRooms.remove(ticket, fetchedCar);
        return new ReturnResult(fetchedCar, FetchOrParkMessage.SUCCESS.toString());
    }

    public boolean isTicketValid(CarTicket ticket) {
        boolean isValid = true;
        if (!parkingRooms.containsKey(ticket)) {
            isValid = false;
        }
        return isValid;
    }

    public boolean isParkingLotFull() {
        boolean isFull = false;
        if (getNowRemainRoom() == 0) {
            isFull = true;
        }
        return isFull;
    }

    public int getNowRemainRoom() {
        return capacity - parkingRooms.size();
    }

    public double getRemainRate() {
        return (double) getNowRemainRoom() / (double) capacity;
    }

    @Override
    public String toString() {
        return "name: " + name + ", remainRooms: " + getNowRemainRoom() + ";\n";
    }
}
