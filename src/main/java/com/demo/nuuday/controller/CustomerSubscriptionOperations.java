package com.demo.nuuday.controller;

import com.demo.nuuday.ApiImpl;
import com.demo.nuuday.entity.Customer;
import com.demo.nuuday.entity.Subscription;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerSubscriptionOperations {

    @Autowired
    private ApiImpl apiImpl;

    @GetMapping("/getAvailableSubscriptions")
    @ApiOperation(value = "Find available subscriptions", notes = "Get all subscriptions available")
    List<Subscription> getSubscriptions() {return apiImpl.getSubscriptions();}

    @GetMapping("/getSubscriptionDetailsById/{subscriptionId}")
    @ApiOperation(value = "Find subscription by id", notes = "Provide an id to look up specific subscription")
    Subscription getSubscriptionDetailsById(@PathVariable Long subscriptionId) {
        return apiImpl.getSubscriptionDetailsById(subscriptionId);
    }

    @GetMapping("/getAvailableCustomers")
    @ApiOperation(value = "Find available customers", notes = "Get all customers available")
    List<Customer> getCustomers() {return apiImpl.getCustomers();}

    @GetMapping("/getCustomer/{customerId}")
    @ApiOperation(value = "Find customer by id", notes = "Provide an id to look up specific customer")
    Customer getCustomer(@PathVariable Long customerId) {
        return apiImpl.getCustomer(customerId);
    }

    @GetMapping("/getCustomerSubscription/{customerId}")
    @ApiOperation(value = "Find subscription by customer id", notes = "Provide an id to look up subscription of specific customer")
    List<String> getCustomerSubscription(@PathVariable Long customerId) {
        return apiImpl.getCustomerSubscriptionName(customerId);
    }

    @PutMapping("/addSubscriptionToCustomer/{customerId}/{subscriptionId}")
    @ApiOperation(value = "Add subscription to customer", notes = "Add a subscription to look up subscription of specific customer")
    ResponseEntity<Object> addSubscription(@PathVariable Long customerId, @PathVariable Long subscriptionId) {
        apiImpl.addSubscriptionToCustomer(customerId,subscriptionId);
        return ResponseEntity.ok("Subscription Added");
    }

    @DeleteMapping("/deleteSubscriptionFromCustomer/{customerId}/{subscriptionId}")
    @ApiOperation(value = "Delete subscription from customer", notes = "Delete a subscription of specific customer")
    void deleteSubscription(@PathVariable Long customerId, @PathVariable Long subscriptionId) {
        apiImpl.deleteSubscription(customerId,subscriptionId);
    }




}
