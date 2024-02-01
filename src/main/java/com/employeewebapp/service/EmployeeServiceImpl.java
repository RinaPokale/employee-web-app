package com.employeewebapp.service;

import com.employeewebapp.model.Employee;
import com.employeewebapp.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public Employee getEmployeeByID(Integer id) {
       Optional<Employee> optional = employeeRepo.findById(id);
       Employee employee = null;
       if(optional.isPresent()){
           employee = optional.get();
       }else {
           throw new RuntimeException("Employee not found for Id::" +id);
       }
       return employee;
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        employeeRepo.deleteById(id);
    }
}
