package com.JGG.cruddemo.service;

import com.JGG.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeServices {
    public List<Employee> findAll();
    public Employee findById(int id);
    public void save (Employee employee);
    public void deleteById(int id);

}
