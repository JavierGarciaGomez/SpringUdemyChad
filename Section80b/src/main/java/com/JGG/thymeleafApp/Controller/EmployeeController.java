package com.JGG.thymeleafApp.Controller;

import com.JGG.thymeleafApp.entity.Employee;
import com.JGG.thymeleafApp.sevice.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        // get employees from db
        List<Employee> theEmployees = employeeService.findAll();

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "employees/list-employees";
    }

    //548
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employees/employee-form";
    }

    //550
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        // save the employees
        employeeService.save(employee);
        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    //	552
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {
        // get the employee from the service
        Employee employee = employeeService.findById(id);
        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        // send it to our form
        return "employees/employee-form";
    }
    //	553
    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id) {
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }


}









