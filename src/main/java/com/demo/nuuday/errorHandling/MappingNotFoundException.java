package com.demo.nuuday.errorHandling;

public class MappingNotFoundException extends RuntimeException {
    public MappingNotFoundException(Long subscriptionId) {
        super("Invalid subscription details " +subscriptionId);
    }
}
