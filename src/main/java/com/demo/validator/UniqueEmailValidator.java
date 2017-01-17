package com.demo.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.model.User;
import com.demo.service.UserService;
import com.demo.validator.annotation.UniqueEmail;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private static final Logger log = LoggerFactory.getLogger(UniqueEmailValidator.class);

    @Autowired
    private UserService userService;

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null || value.length() == 0) {
            return true;
        }

        Optional<User> user = userService.findByEmail(value);

        log.info("Does User exist: {}", user.isPresent());
        return !user.isPresent();
    }
}