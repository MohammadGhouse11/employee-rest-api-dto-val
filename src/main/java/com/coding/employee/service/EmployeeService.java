package com.coding.employee.service;

import com.coding.employee.dto.EmployeeDTO;
import com.coding.employee.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeeById(Long id);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO updateEmployee(Long id,EmployeeDTO updatedEmployeeDTO);
    EmployeeDTO partialUpdateEmployee(Long id, EmployeeDTO partialUpdateEmpDTO);
    void deleteEmployee(Long id);
}
