package com.JGG.thymeleafApp.dao;

import com.JGG.thymeleafApp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//550
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //550 sort by lastName
    public List<Employee> findAllByOrderByLastNameAsc();

}
