package com.demo.nuuday.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Mapping {

    public Mapping() {}

    public Mapping(Long id, Long customerId, Long subscriptionId) {
        this.id = id;
        this.customerId = customerId;
        this.subscriptionId = subscriptionId;
    }
    public Mapping(Long customerId, Long subscriptionId) {
        this.customerId = customerId;
        this.subscriptionId = subscriptionId;
    }


    @Id
    @GeneratedValue
    private Long id;
    private Long customerId;
    private Long subscriptionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }



}
