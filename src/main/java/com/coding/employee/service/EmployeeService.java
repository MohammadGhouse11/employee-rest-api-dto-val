package com.coding.employee.service;

import com.coding.employee.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {

    Employee createEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Long id,Employee updatedEmployee);
    Employee partialUpdateEmployee(Long id, Employee partialUpdateEmp);
    void deleteEmployee(Long id);
}
