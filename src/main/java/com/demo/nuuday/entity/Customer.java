package com.demo.nuuday.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

    public Customer() {}

    public Customer(Long customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;

    }

    @Id
    private Long customerId;
    private String customerName;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
