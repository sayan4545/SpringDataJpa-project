package com.dev.sayan.algocamp.springdatajpaproject.advices.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
