package com.JGG.thymeleafApp.dao;

import com.JGG.thymeleafApp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;



public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!
	
}
