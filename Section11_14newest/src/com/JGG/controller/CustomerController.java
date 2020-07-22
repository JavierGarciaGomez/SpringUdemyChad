package com.JGG.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    // 152. add an initbinder ... to convert trim input strings
    // remove leading and trailing whitespace
    // resolve issue for our validation

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    //147
    @RequestMapping("/showCustomerForm")
    public String showCustomerForm(Model model) {
        Customer customer = new Customer();
        System.out.println(customer);
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    // 148 @Valid attribute and bindingresult
    @RequestMapping("/processCustomer")
    public String processCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        System.out.println("Im here"+bindingResult);
        if (bindingResult.hasErrors()){
            System.out.println("It has errors");
            return "customer-form";
        }
        else {
            System.out.println("It doesnt have errores");
            return "customer-confirmation";
        }
    }
}
