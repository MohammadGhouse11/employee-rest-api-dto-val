package com.coding.employee.validation;

import com.coding.employee.repository.EmployeeRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class customUniqueElementValidator implements ConstraintValidator<UniqueEmail,String> {
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return !employeeRepository.existsByEmail(email);
    }
}
