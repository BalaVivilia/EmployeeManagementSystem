package com.example.EmployeeManagementSystemProject.service;

import com.example.EmployeeManagementSystemProject.entity.Employee;
import com.example.EmployeeManagementSystemProject.repository.EmployeeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class EmployeeServiceImpln implements EmployeeService{

    @Autowired
    EmployeeRepo empRepo;
    @Override
    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        empRepo.save(employee);
    }

    @Override
    public Employee updateEmployeeById(int id) {

        Employee update=empRepo.getById(id);
        //update.setId(updateEmp.getId());
        return empRepo.save(update);
    }

    @Override
    public void deleteEmployeeById(int id) {
        empRepo.deleteById(id);

    }
}
