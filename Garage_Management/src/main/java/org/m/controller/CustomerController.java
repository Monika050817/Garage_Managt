package org.m.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.m.entity.Customer;
import org.m.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {


    private final CustomerRepository customerRepository;

    // Add Customer
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    // Get All Customers
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}