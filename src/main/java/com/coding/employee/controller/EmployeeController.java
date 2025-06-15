package com.coding.employee.controller;

import com.coding.employee.dto.EmployeeDTO;
import com.coding.employee.entity.Employee;
import com.coding.employee.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value= "/api/v1/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody @Valid EmployeeDTO employeeDTO){
        EmployeeDTO savedEmp = employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long id,@RequestBody @Valid EmployeeDTO employeeDTO){
        return ResponseEntity.ok(employeeService.updateEmployee(id,employeeDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        //Ok --> To Return message body
        //No-content --> No message body
        return new ResponseEntity<>("Employee Deleted with id: "+id,HttpStatus.OK);
    }
    @PatchMapping(value = "/{id}")
    public ResponseEntity<EmployeeDTO> partialUpdateEmp(@PathVariable  Long id,@RequestBody @Valid EmployeeDTO employeeDTO){
        return ResponseEntity.ok(employeeService.partialUpdateEmployee(id,employeeDTO));
    }

}
