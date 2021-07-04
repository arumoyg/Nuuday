package com.demo.nuuday.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subscription {

    public Subscription() {}

    public Subscription(Long subscriptionId, String subscriptionName) {
        this.subscriptionId = subscriptionId;
        this.subscriptionName = subscriptionName;

    }

    @Id
    private Long subscriptionId;
    private String subscriptionName;


    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getSubscriptionName() {
        return subscriptionName;
    }

    public void setSubscriptionName(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }


}
