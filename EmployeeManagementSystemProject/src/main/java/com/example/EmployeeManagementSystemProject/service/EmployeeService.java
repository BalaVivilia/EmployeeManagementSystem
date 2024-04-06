package com.example.EmployeeManagementSystemProject.service;

import com.example.EmployeeManagementSystemProject.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public void saveEmployee(Employee employee);
    public Employee updateEmployeeById(int id);
    public void deleteEmployeeById(int id);
}
