package com.demo.nuuday.errorHandling;

public class SubscriptionNotFoundException extends RuntimeException{

    public SubscriptionNotFoundException(Long subscriptionId) {
        super("Invalid subscription details " +subscriptionId);
    }
}
