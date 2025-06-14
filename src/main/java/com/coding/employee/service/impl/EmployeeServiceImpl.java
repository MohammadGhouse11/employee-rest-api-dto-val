package com.coding.employee.service.impl;

import com.coding.employee.dto.EmployeeDTO;
import com.coding.employee.entity.Employee;
import com.coding.employee.exception.BadRequestException;
import com.coding.employee.exception.ResourceNotFoundException;
import com.coding.employee.mapper.EmployeeMapper;
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
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        if(employeeDTO.getName() == null || employeeDTO.getName().trim().isEmpty()) {
            throw new BadRequestException("Employee name cannot be empty");
        }
        Employee employee = EmployeeMapper.mapToEntity(employeeDTO);
        Employee saved = employeeRepository.save(employee);
        return EmployeeMapper.mapToDTO(saved);

    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with id Not Found: " + id));
        return EmployeeMapper.mapToDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> all = employeeRepository.findAll();
        return all.stream().map(EmployeeMapper::mapToDTO).toList();
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO updatedEmployeeDTO) {
        Employee existingEmp = employeeRepository.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("Employee with id Not Found: "+id));
        existingEmp.setName(updatedEmployeeDTO.getName());
        existingEmp.setEmail(updatedEmployeeDTO.getEmail());
        existingEmp.setDepartment(updatedEmployeeDTO.getDepartment());
        Employee saved = employeeRepository.save(existingEmp);
        return EmployeeMapper.mapToDTO(saved);
    }

    @Override
    public EmployeeDTO partialUpdateEmployee(Long id, EmployeeDTO partialUpdateEmpDTO) {
        Employee existingEmp = employeeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Employee with id Not Found: "+id));
        if(partialUpdateEmpDTO.getName()!=null && partialUpdateEmpDTO.getName()!=""){
            existingEmp.setName(partialUpdateEmpDTO.getName());
        }
        if(partialUpdateEmpDTO.getDepartment()!=null && partialUpdateEmpDTO.getDepartment()!=""){
            existingEmp.setDepartment(partialUpdateEmpDTO.getDepartment());
        }
        if(partialUpdateEmpDTO.getEmail()!=null && partialUpdateEmpDTO.getEmail()!=""){
            existingEmp.setEmail(partialUpdateEmpDTO.getEmail());
        }
        Employee saved = employeeRepository.save(existingEmp);
        return EmployeeMapper.mapToDTO(saved);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee existingEmp = employeeRepository.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("Employee with id Not Found: "+id));
        employeeRepository.delete(existingEmp);
    }
}
