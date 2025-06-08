package com.coding.employee.service;

import com.coding.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Long id,Employee updatedEmployee);
    void deleteEmployee(Long id);
}
