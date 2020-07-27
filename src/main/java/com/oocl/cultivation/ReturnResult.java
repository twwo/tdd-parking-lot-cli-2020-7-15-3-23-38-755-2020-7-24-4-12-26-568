package com.oocl.cultivation;

public class ReturnResult {
    private Object result;

    private String message;

    public ReturnResult() {
        this.result = null;
        this.message = FetchOrParkMessage.SUCCESS.toString();
    }

    public ReturnResult(Object result, String wrongMessage) {
        this.result = result;
        this.message = wrongMessage;
    }

    public Object getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
