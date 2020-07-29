package com.JGG.dao;

import com.JGG.entity.Customer;
import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    //299
    void saveCustomer(Customer customer);
}
