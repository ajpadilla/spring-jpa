package com.workshop.springjpa.repositories;

import com.workshop.springjpa.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
