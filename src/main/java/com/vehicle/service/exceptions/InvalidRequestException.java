package com.vehicle.service.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidRequestException extends RuntimeException{

    public InvalidRequestException(String message) {
        super(message + "\n Error Status " + HttpStatus.BAD_REQUEST);
    }
}
