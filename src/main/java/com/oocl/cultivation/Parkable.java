package com.oocl.cultivation;

public interface Parkable {
    ReturnResult park(Car car);

    ReturnResult fetch(CarTicket carTicket);

    boolean isFull();

}
