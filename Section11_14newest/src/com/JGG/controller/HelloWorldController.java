package com.JGG.controller;

import com.JGG.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello") // to solve ambiguous mapping. All below is going to be here too.
public class HelloWorldController {
    // need a controller method to show the initial HTML form
    // 127. This was made in a different controller so this method is changed accordingly
    @RequestMapping("/showForm")
    public String showForm(Model model) {
        //127 Create a student object
        Student student = new Student();
        // 127. Student object to the model
        model.addAttribute("student", student);
        return "helloworld-form";
    }

    // need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    // 115 method to read form data and add data to the model
    // 120 adding the @RequestParam
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, @RequestParam("lastName") String lastName, Model model){
        // Read the request parameter from the HTML form
        String name = request.getParameter("studentName");
        // UpperString
        name=name.toUpperCase();
        // Create the message
        String result = "Yo "+name;
        // Add message to the model
        model.addAttribute("message", result);
        model.addAttribute("firstName", name);
        // 120 RequestParam
        model.addAttribute("lastName", lastName);
        return "helloworld";
    }

    // 128
    @RequestMapping("/processFormTags")
    public String processFormTags(@ModelAttribute("student") Student student) {
        System.out.println(student);
        return "student-confirmation";
    }








}
