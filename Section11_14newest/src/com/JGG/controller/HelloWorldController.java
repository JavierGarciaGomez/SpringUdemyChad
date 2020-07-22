package com.JGG.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {
    // need a controller method to show the initial HTML form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    // 115 method to read form data and add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){
        // Read the request parameter from the HTML form
        String name = request.getParameter("studentName");
        // UpperString
        name=name.toUpperCase();
        // Create the message
        String result = "Yo "+name;
        // Add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }



}
