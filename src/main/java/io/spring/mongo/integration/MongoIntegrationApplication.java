package io.spring.mongo.integration;

import io.spring.mongo.integration.model.Customer;
import io.spring.mongo.integration.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@Slf4j
public class MongoIntegrationApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(MongoIntegrationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        //save a couple of customers
        repository.save(new Customer("Alice", "Smith"));
        repository.save(new Customer("Bob", "Smith"));

        List<Customer> customers = repository.findByLastName("Smith");
        //fetching all the customers
        log.info("Customers found with findAllByLastName(): ");
        customers.forEach(customer -> log.info(customer.toString()));

        log.info("Customer found with findByFirstname('Alice'): {}",
                repository.findByFirstName("Alice"));

        log.info("Customers found with findAll(): ");
        repository.findAll().forEach(customer -> log.info(customer.toString()));
    }

}
