package com.demo.nuuday.errorHandling;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(Long customerId, String error) {
        super("Customer Not found "+error);
    }
}
