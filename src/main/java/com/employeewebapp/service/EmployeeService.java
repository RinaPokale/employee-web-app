package com.employeewebapp.service;

import com.employeewebapp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);
    Employee getEmployeeByID(Integer id);
    void deleteEmployeeById(Integer id);
}
