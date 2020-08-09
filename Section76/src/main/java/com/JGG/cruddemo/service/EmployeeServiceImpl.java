package com.JGG.cruddemo.service;

import com.JGG.cruddemo.dao.EmployeeRepository;
import com.JGG.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//525, 532, 535
//535change from EmployeeDAO to EmployeeRepository and refactor all and delete @Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {

    //535
    private EmployeeRepository employeeRepository;

    //532 Adding the qualifier to avoid confussion between Hibernate and JPA
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    //535
    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;

    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
