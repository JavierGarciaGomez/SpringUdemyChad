package com.JGG.thymeleafApp.Controller;

import com.JGG.thymeleafApp.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//543
@Controller
@RequestMapping("/employees")
public class EmployeeController {
    // 543 load employee data
    private List<Employee> employees;

    //543
    @PostConstruct
    private void loadData(){
        // create employees
        Employee employee1 = new Employee(1, "Leslie", "Andrews", "leslie@mail.com");
        Employee employee2 = new Employee(2, "Emma", "Baumgarten", "emma@mail.com");
        Employee employee3 = new Employee(3, "Avani", "Gupta", "avani@mail.com");
        // create the list
        employees=new ArrayList<>();
        // add to the list
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
    }
    //544 mapping for list
    @GetMapping("/list")
    public String listEmployees(Model model){
        //add to spring model
        model.addAttribute("employees", employees);
        return "list-employees";

    }
}
