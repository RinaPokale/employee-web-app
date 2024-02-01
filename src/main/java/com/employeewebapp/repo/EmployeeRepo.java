package com.employeewebapp.repo;

import com.employeewebapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JpaRepository<className(tableName), PrimaryKey type>
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
