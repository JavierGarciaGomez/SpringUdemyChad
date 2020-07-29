package com.JGG.controller;

import com.JGG.dao.CustomerDAO;
import com.JGG.entity.Customer;
import com.JGG.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

/*
291 Removed because now is injected in the service
    // need to inject the customer dao
    @Autowired
    private CustomerDAO customerDAO;
*/
    //291 inject our customer service
    @Autowired
    private CustomerService customerService;


    @GetMapping("list")// changed in 288 @RequestMapping("/list")
    public String listCustomers(Model theModel) {

        // get customers from the dao... 291 changed
        List<Customer> theCustomers = customerService.getCustomers();

        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }

}