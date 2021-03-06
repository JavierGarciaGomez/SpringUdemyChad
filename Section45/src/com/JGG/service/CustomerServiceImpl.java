package com.JGG.service;

import com.JGG.dao.CustomerDAO;
import com.JGG.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// 290
@Service
public class CustomerServiceImpl implements CustomerService {

    //need to inject the customer dao
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers(); // delegatin calls to DAO
    }


    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    //304
    @Override
    @Transactional
    public Customer getCustomer(int id) {
        Customer customer = customerDAO.getCustomer(id);
        return customer;
    }

    //311
    @Override
    @Transactional
    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }


}
