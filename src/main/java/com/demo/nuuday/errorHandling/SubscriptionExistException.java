package com.demo.nuuday.errorHandling;

public class SubscriptionExistException extends RuntimeException{

    public SubscriptionExistException() {
        super("Subscription already exist ");
    }
}
