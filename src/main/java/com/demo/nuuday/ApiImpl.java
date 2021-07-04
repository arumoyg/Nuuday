package com.demo.nuuday;

import com.demo.nuuday.entity.Customer;
import com.demo.nuuday.entity.Mapping;
import com.demo.nuuday.entity.Subscription;
import com.demo.nuuday.errorHandling.CustomerNotFoundException;
import com.demo.nuuday.errorHandling.SubscriptionExistException;
import com.demo.nuuday.errorHandling.SubscriptionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApiImpl {

    @Autowired
    private MappingRepository mappingRepo;

    @Autowired
    private SubscriptionRepository repo;

    @Autowired
    private CustomerRepository custRepo;


    public List<Mapping> getMapByCustomer(Long customerId) {
        return mappingRepo.findAll()
                .stream()
                .filter(a -> a.getCustomerId().equals(customerId))
                .collect(Collectors.toList());
    }

    //get the list of mapping of the customer with subscriptions
    //from the list get the subscription ids
    //search the subscription table with the subscription ID to get the subscription name

    public List<String> getCustomerSubscriptionName(Long customerId) {
        List<Mapping> m = getMapByCustomer(customerId);
        List<Long> subIds = new ArrayList<Long>();
        List<String> subs = new ArrayList<String>();
        m.forEach(x -> subIds.add(x.getSubscriptionId()));
        for (Long e: subIds) {
            subs.add(getSubscriptionName(e));
        }
        return subs;
    }

    public String getSubscriptionName(Long subscriptionId) {
        return repo.findById(subscriptionId).map(x->x.getSubscriptionName()).orElseThrow(() -> new SubscriptionNotFoundException(subscriptionId));
    }

    //Add
    //Check customer is there or not
    //While adding If customer has already the subscription throw exception, already added
    //Add subscription to the customer if not there
    public void addSubscriptionToCustomer(Long customerId, Long subscriptionId) {
        getCustomer(customerId);
        List<Mapping> m = getMapByCustomer(customerId);
        for (Mapping x: m) {
            if (subscriptionId.equals(x.getSubscriptionId()))
                throw new SubscriptionExistException();
        }
        mappingRepo.save(new Mapping(customerId,subscriptionId));
    }

    public List<Subscription> getSubscriptions() {
        return repo.findAll();
    }

    public Subscription getSubscriptionDetailsById (Long subscriptionId) {
        return repo.findById(subscriptionId).orElseThrow(() -> new SubscriptionNotFoundException(subscriptionId));
    }

    public List<Customer> getCustomers() {
        return custRepo.findAll();
    }

    public Customer getCustomer(Long customerId) {
        return custRepo.findById(customerId).orElseThrow(() -> new CustomerNotFoundException(customerId,"error"));
    }

    public void deleteSubscription(Long customerId, Long subscriptionId) {
        getCustomer(customerId);
        List<Mapping> m = getMapByCustomer(customerId);
        for (Mapping x: m) {
            if (subscriptionId.equals(x.getSubscriptionId())) {
                mappingRepo.deleteById(x.getId());
                break;
            }
            else
                throw new SubscriptionNotFoundException(subscriptionId);
        }
    }
}
