package com.JGG.springdemo.rest;

import com.JGG.springdemo.entity.Customer;
import com.JGG.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//487, 489, 492
@RestController
@RequestMapping("/api")
public class CustomerRestController {
    //489 Autowire the customer service
    @Autowired
    private CustomerService customerService;
    //489 Add mapping for GET / customers
    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    //489 add mapping for GET / customers / customerID
    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        Customer customer = customerService.getCustomer(customerId);
        //492
        if(customer==null){
            throw new CustomerNotFoundException("Customer id not found - "+customerId);
        }

        return customer;

    }


}
