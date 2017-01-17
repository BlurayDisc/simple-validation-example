package com.demo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.demo.validator.annotation.MobileNumber;

public class MobileNumberValidator implements ConstraintValidator<MobileNumber, String> {

    @Override
    public void initialize(MobileNumber constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null || value.length() == 0) {
            return true;
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        return true;
    }
}