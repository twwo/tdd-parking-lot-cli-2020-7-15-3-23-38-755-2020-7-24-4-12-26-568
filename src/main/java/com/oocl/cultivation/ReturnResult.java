package com.oocl.cultivation;

public class ReturnResult {
    private ReturnThing result;

    private String message;

    public ReturnResult(ReturnThing result, String wrongMessage) {
        this.result = result;
        this.message = wrongMessage;
    }

    public ReturnThing getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }
}
