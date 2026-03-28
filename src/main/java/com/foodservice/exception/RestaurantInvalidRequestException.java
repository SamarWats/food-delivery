package com.foodservice.exception;

public class RestaurantInvalidRequestException extends RuntimeException {
    public RestaurantInvalidRequestException(String message) {
        super(message);
    }
}