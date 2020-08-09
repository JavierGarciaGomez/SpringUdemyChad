package com.JGG.cruddemo.dao;

import com.JGG.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//535, 539
// 539 added and deleted @RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // That's it, no need to write any code
}
