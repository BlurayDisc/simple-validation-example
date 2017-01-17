package com.demo.validator.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;

import com.demo.validator.UniqueEmailValidator;

@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = UniqueEmailValidator.class)
public @interface UniqueEmail {

    String message() default "The email you have entered is already in use";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};

}
