package com.demo.validator.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;

import com.demo.validator.MobileNumberValidator;

@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = MobileNumberValidator.class)
public @interface MobileNumber {

    String message() default "You need to provide a valid mobile/cell number and country";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
