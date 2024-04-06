package com.example.EmployeeManagementSystemProject.controller;

import com.example.EmployeeManagementSystemProject.entity.Employee;
import com.example.EmployeeManagementSystemProject.service.EmployeeService;
import com.example.EmployeeManagementSystemProject.service.EmployeeServiceImpln;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/emp")
public class EmployeeContoller {

    @Autowired
    EmployeeServiceImpln empService;

    @GetMapping("/index")
   public String viewEmployees(Model model)
   {
       //Adding  data attributes to model interface
       model.addAttribute("listEmployees",empService.getAllEmployees());
       return "index";
   }
    @GetMapping("/addNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("Employee", employee);
        return "add_new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveNewEmployee(@ModelAttribute("Employee") Employee employee) {
        // save employee to database
        empService.saveEmployee(employee);
        return "redirect:/index";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable  int id, Model model) {

        // get employee from the service
        Employee employee = empService.updateEmployeeById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("Employee", employee);
        return "update_employee";
    }
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") int id) {

        // call delete employee method
        empService.deleteEmployeeById(id);
        return "redirect:/index";
    }
}
