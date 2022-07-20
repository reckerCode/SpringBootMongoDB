package io.spring.mongo.integration;

import io.spring.mongo.integration.model.Customer;
import io.spring.mongo.integration.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

@DataMongoTest
class MongoDbSpringIntegrationTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void test() {
        Customer testCustomer = new Customer("Alice", "Smith");
        Customer testCustomer1 = new Customer("Bob", "Smith");
        Customer testCustomer2 = new Customer("Dave", "Smith");
        Customer testCustomer3 = new Customer("Terry", "Smith");

        customerRepository.save(testCustomer1);
        customerRepository.save(testCustomer2);
        customerRepository.save(testCustomer3);

        Customer customer = customerRepository.findByFirstName("Alice");
        List<Customer> customers = customerRepository.findByLastName("Smith");
        int totalCustomers = customerRepository.findAll().size();

        Assertions.assertEquals(customer.firstName, testCustomer.firstName);
        Assertions.assertEquals(customer.lastName, testCustomer.lastName);
        Assertions.assertEquals(totalCustomers, customers.size());

    }
}
