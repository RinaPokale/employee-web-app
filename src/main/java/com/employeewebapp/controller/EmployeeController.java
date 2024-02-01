package com.employeewebapp.controller;

import com.employeewebapp.model.Employee;
import com.employeewebapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //display list of employees
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "home";
    }
    //listEmployees is reference variable

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        //create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        //thymeleaf template will access this empty 'employee' object to bind form data
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        //save employee to the database
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable Integer id, Model model){
        //get employee form the service
        Employee employee = employeeService.getEmployeeByID(id);
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        //call delete employee method
        employeeService.deleteEmployeeById(id);
        return  "redirect:/";
    }
}
