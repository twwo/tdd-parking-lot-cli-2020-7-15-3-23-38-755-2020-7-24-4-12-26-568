package com.oocl.cultivation;

public class ReturnResult {
    private ReturnThing result;

    private String message;

    public ReturnResult() {
        this.result = null;
        this.message = FetchOrParkMessage.SUCCESS.toString();
    }

    public ReturnResult(ReturnThing result, String wrongMessage) {
        this.result = result;
        this.message = wrongMessage;
    }

    public ReturnThing getResult() {
        return result;
    }

    public void setResult(ReturnThing result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
