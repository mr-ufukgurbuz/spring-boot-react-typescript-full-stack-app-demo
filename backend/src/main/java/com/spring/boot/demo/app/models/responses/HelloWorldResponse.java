package com.spring.boot.demo.app.models.responses;

public class HelloWorldResponse implements IResponse
{
    private String message;

    public HelloWorldResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("HelloWorldResponse [message=%s]", message);
    }
}
