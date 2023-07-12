package com.example.demo.Model;

public class ResponseObject {
    private String status;
    private String message;


    public ResponseObject() {}

    public ResponseObject(String status, String message) {
        this.status = status;
        this.message = message;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}