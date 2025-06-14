package com.coding.employee.mapper;

import com.coding.employee.dto.EmployeeDTO;
import com.coding.employee.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDTO mapToDTO(Employee emp){
        EmployeeDTO dto= new EmployeeDTO();
        dto.setName(emp.getName());
        dto.setEmail(emp.getEmail());
        dto.setDepartment(emp.getDepartment());
        return dto;
    }

    public static Employee mapToEntity(EmployeeDTO employeeDTO){
        Employee emp = new Employee();
        emp.setName(employeeDTO.getName());
        emp.setDepartment(employeeDTO.getDepartment());
        emp.setEmail(employeeDTO.getEmail());
        return emp;
    }

}
