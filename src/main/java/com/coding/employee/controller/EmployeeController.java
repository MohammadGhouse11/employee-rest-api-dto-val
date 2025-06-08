package com.coding.employee.controller;

import com.coding.employee.entity.Employee;
import com.coding.employee.service.EmployeeService;
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
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee savedEmp = employeeService.createEmployee(employee);
        return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id,@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.updateEmployee(id,employee));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        //Ok --> To Return message body
        //No-content --> No message body
        return new ResponseEntity<>("Employee Deleted with id: "+id,HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Employee> partialUpdateEmp(@PathVariable  Long id,@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.partialUpdateEmployee(id,employee));
    }

}
