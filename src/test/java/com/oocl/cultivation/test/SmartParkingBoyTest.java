package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SmartParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class SmartParkingBoyTest {
    @Test
    void should_add_car_into_the_most_empty_parkinglot_when_park_by_smartparking_boy_given_car() {
        //given
        ParkingLot parkingLotWith5Room = new ParkingLot(5);
        parkingLotWith5Room.setName("parkingLotWith5Room");
        ParkingLot parkingLotWith10Room = new ParkingLot(10);
        parkingLotWith10Room.setName("parkingLotWith10Room");
        ParkingLot parkingLotWith15Room = new ParkingLot(15);
        parkingLotWith15Room.setName("parkingLotWith15Room");
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(
                Arrays.asList(parkingLotWith5Room, parkingLotWith10Room, parkingLotWith15Room)
        );
        StringBuilder maxRoomParkingLotList = new StringBuilder();

        //when
        for (int i = 0; i < 10; i++) {
            smartParkingBoy.park(new Car());
            maxRoomParkingLotList.append(smartParkingBoy.getMaxRoomParkingLot().toString());
        }

        //then
        assertEquals("name: parkingLotWith15Room, remainRooms: 14;\n" +
                "name: parkingLotWith15Room, remainRooms: 13;\n" +
                "name: parkingLotWith15Room, remainRooms: 12;\n" +
                "name: parkingLotWith15Room, remainRooms: 11;\n" +
                "name: parkingLotWith15Room, remainRooms: 10;\n" +
                "name: parkingLotWith10Room, remainRooms: 9;\n" +
                "name: parkingLotWith15Room, remainRooms: 9;\n" +
                "name: parkingLotWith10Room, remainRooms: 8;\n" +
                "name: parkingLotWith15Room, remainRooms: 8;\n" +
                "name: parkingLotWith10Room, remainRooms: 7;\n", maxRoomParkingLotList.toString());
    }
}
