package org.m.controller;

//import com.garage.garage_management.entity.Customer;
//import com.garage.garage_management.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

//    @Autowired
//    private CustomerRepository customerRepository;

//    // Add Customer
//    @PostMapping
//    public Customer addCustomer(@RequestBody Customer customer) {
//        return customerRepository.save(customer);
//    }
//
//    // Get All Customers
//    @GetMapping
//    public List<Customer> getAllCustomers() {
//        return customerRepository.findAll();
//    }
}