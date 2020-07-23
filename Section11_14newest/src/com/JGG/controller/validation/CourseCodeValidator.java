package com.JGG.controller.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//164
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCodeValidator {
    //165
    // Define default course code
    public String prefixValue() default "LUV";


    // Define default error message
    public String message() default "must start with LUV";

    // Define default groups
    public Class<?>[] groups() default {};

    // Define default payloads (Additional information about the validation error)
    public Class<? extends Payload>[] payload() default {};
}
