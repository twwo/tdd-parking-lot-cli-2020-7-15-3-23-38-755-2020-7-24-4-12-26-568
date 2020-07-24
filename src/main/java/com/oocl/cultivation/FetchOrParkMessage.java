package com.oocl.cultivation;

public enum FetchOrParkMessage {
    NO_TICKET("Please provide your parking ticket."),
    UNRECOGNIZED_TICKET("Unrecognized parking ticket."),
    NO_PARKING_POSITION("Please provide your parking ticket"),
    SUCCESS("success");


    private String message;

    FetchOrParkMessage(String message) {
        this.message = message;
    }
}
