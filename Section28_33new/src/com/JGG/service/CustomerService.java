package com.JGG.service;

import com.JGG.entity.Customer;

import java.util.List;

//290, 298

public interface CustomerService {
    public List<Customer> getCustomers();

    //298
    public void saveCustomer(Customer customer);

    //304
    public Customer getCustomer(int id);

    //311
    public void deleteCustomer(int id);
}
