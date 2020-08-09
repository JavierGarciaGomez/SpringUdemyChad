package com.JGG.cruddemo.dao;

import com.JGG.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
//535
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // That's it, no need to write any code
}
