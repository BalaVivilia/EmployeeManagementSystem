package com.example.EmployeeManagementSystemProject.repository;

import com.example.EmployeeManagementSystemProject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
