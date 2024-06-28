package com.workshop.springjpa.repositories;

import com.workshop.springjpa.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
