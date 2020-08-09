package com.JGG.cruddemo.dao;

import com.JGG.cruddemo.entity.Employee;

import java.util.List;

//525
public interface EmployeeDAO {
    public List<Employee> findAll();

    public Employee findById(int id);
    public void save (Employee employee);
    public void deleteById(int id);
}
