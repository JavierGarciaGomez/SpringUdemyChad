package com.JGG.springdemo.rest;

import com.JGG.springdemo.entity.Customer;
import com.JGG.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//487, 489, 492, 496, 499
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

    //496 add mapping for post /customers - add new
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){
        // set id to 0. So is a new iten and not an update
        customer.setId(0);
        customerService.saveCustomer(customer);
        return customer;
    }

    //499 Update existing customer
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return customer;
    }
    //501 delete customer
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){
        Customer tempCustomer = customerService.getCustomer(customerId);
        // throw exception if is null
        if(tempCustomer==null){
            throw new CustomerNotFoundException("Customer not found "+customerId);
        }
        customerService.deleteCustomer(customerId);
        return "Delete customer id - "+customerId;
    }
}
