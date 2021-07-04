package com.demo.nuuday;

import com.demo.nuuday.entity.Customer;
import com.demo.nuuday.entity.Mapping;
import com.demo.nuuday.entity.Subscription;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NuudayApplication {

    public static void main(String[] args) {
        SpringApplication.run(NuudayApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(CustomerRepository customerRepository, SubscriptionRepository subscriptionRepository, MappingRepository mappingRepository) {
        return args -> {
            customerRepository.save(new Customer(1L,"Arumoy"));
            customerRepository.save(new Customer(2L,"Anders"));
            customerRepository.save(new Customer(3L,"Jens"));
            customerRepository.save(new Customer(4L,"Sanaria"));
            subscriptionRepository.save(new Subscription(1L, "Brodband 1000/10 Mbps"));
            subscriptionRepository.save(new Subscription(2L, "Netflix"));
            subscriptionRepository.save(new Subscription(3L, "Mobile 5G"));

            mappingRepository.save(new Mapping(1L,1L, 1L));
            mappingRepository.save(new Mapping(2L,1L, 3L));
            mappingRepository.save(new Mapping(3L,2L, 2L));
            mappingRepository.save(new Mapping(4L,2L, 3L));
            mappingRepository.save(new Mapping(5L,3L, 1L));
            mappingRepository.save(new Mapping(6L,3L, 2L));

        };
    }

}
