package io.spring.mongo.MongoIntegration;

import io.spring.mongo.MongoIntegration.model.Customer;
import io.spring.mongo.MongoIntegration.repository.CustomerRepository;
import io.spring.mongo.MongoIntegration.service.CustomerService;
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
	private CustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(MongoIntegrationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerService.deleteAllCustomers();

		//save a couple of customers
		customerService.saveCustomer(new Customer("Alice", "Smith"));
		customerService.saveCustomer(new Customer("Bob", "Smith"));

		List<Customer> customers = customerService.getAllCustomersByLastName("Smith");
		//fetching all the customers
		log.info("Customers found with findAllByLastName(): ");
		customers.forEach(System.out::println);

		log.info("Customer found with findByFirstname('Alice'): {}",
				customerService.getCustomerByFirstName("Alice"));

		log.info("Customers found with findAll(): ");
		customerService.findAllCustomers();
	}

}
