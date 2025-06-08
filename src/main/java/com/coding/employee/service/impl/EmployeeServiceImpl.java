package com.coding.employee.service.impl;

import com.coding.employee.entity.Employee;
import com.coding.employee.repository.EmployeeRepository;
import com.coding.employee.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee existingEmp = employeeRepository.findById(id).orElse(null);
        existingEmp.setName(updatedEmployee.getName());
        existingEmp.setEmail(updatedEmployee.getEmail());
        existingEmp.setDepartment(updatedEmployee.getDepartment());
        return employeeRepository.save(existingEmp);
    }

    @Override
    public Employee partialUpdateEmployee(Long id, Employee partialUpdateEmp) {
        Employee existingEmp = employeeRepository.findById(id).orElse(null);
        if(partialUpdateEmp.getName()!=null && partialUpdateEmp.getName()!=""){
            existingEmp.setName(partialUpdateEmp.getName());
        }
        if(partialUpdateEmp.getDepartment()!=null && partialUpdateEmp.getDepartment()!=""){
            existingEmp.setDepartment(partialUpdateEmp.getDepartment());
        }
        if(partialUpdateEmp.getEmail()!=null && partialUpdateEmp.getEmail()!=""){
            existingEmp.setEmail(partialUpdateEmp.getEmail());
        }
        return employeeRepository.save(existingEmp);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee existingEmp = employeeRepository.findById(id).orElse(null);
        employeeRepository.delete(existingEmp);
    }
}
