package com.oocl.cultivation;

import java.util.Arrays;
import java.util.List;

public class ParkingManager {
    private List<Parkable> parkables;

    public ParkingManager(Parkable...parkables) {
        this.parkables = Arrays.asList(parkables);
    }

    public ReturnResult park(Car car) {
        return null;
    }
}
