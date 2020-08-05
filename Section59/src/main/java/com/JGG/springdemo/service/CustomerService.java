package com.JGG.springdemo.service;

import java.util.List;

import com.JGG.springdemo.entity.Customer;
//484
public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
