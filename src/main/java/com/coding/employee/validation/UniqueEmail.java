package com.coding.employee.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.hibernate.validator.internal.constraintvalidators.hv.UniqueElementsValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = customUniqueElementValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {
    String message() default "Email already Exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
