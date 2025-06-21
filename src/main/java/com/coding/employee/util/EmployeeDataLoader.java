package com.coding.employee.util;

import com.coding.employee.entity.Employee;
import com.coding.employee.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class EmployeeDataLoader {
    @Bean
    public CommandLineRunner loadData(EmployeeRepository repository){
        return  args -> {
            repository.save(new Employee("John Doe", "john.doe@example.com", "IT", 55000.0, "Software Engineer"));
            repository.save(new Employee("Jane Smith", "jane.smith@example.com", "HR", 48000.0, "HR Manager"));
            repository.save(new Employee("Raj Patel", "raj.patel@example.com", "Finance", 60000.0, "Accountant"));
            repository.save(new Employee("Sara Lee", "sara.lee@example.com", "IT", 62000.0, "Senior Developer"));
            repository.save(new Employee("Mike Johnson", "mike.johnson@example.com", "Marketing", 47000.0, "Marketing Lead"));
        };
    }
}
