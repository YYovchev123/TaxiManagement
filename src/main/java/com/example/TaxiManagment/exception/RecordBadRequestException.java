package com.example.TaxiManagment.exception;

public class RecordBadRequestException extends RuntimeException{
    public RecordBadRequestException() {
        super();
    }

    public RecordBadRequestException(String message) {
        super(message);
    }
}
