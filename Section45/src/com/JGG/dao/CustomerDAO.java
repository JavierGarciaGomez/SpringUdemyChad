package com.JGG.dao;

import com.JGG.entity.Customer;
import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    //299
    public void saveCustomer(Customer customer);

    public Customer getCustomer(int id);

    //311
    public void deleteCustomer(int id);
}
