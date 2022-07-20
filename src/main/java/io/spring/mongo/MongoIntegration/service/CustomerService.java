package io.spring.mongo.MongoIntegration.service;

import io.spring.mongo.MongoIntegration.model.Customer;
import io.spring.mongo.MongoIntegration.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomerByFirstName(String firstName){
        return customerRepository.findByFirstName(firstName);
    }

    public List<Customer> getAllCustomersByLastName(String lastName){
        return customerRepository.findByLastName(lastName);
    }

    public void saveCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void deleteAllCustomers(){
        customerRepository.deleteAll();
    }
    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }
}
