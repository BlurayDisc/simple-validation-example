package com.demo.validator;

import java.util.Collections;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.apache.log4j.Logger;
import org.hibernate.validator.HibernateValidator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.demo.model.User;

public class ValidatorITest {

    private static final Logger log = Logger.getLogger(ValidatorITest.class);

    private LocalValidatorFactoryBean localValidatorFactory;

    private Set<ConstraintViolation<User>> violations;

    private User user;

    @Before
    public void setup() {

        violations = Collections.emptySet();

        localValidatorFactory = new LocalValidatorFactoryBean();
        localValidatorFactory.setProviderClass(HibernateValidator.class);
        localValidatorFactory.afterPropertiesSet();
    }

    @After
    public void destroy() {

        for (ConstraintViolation<?> violation : violations) {
            log.info(String.format("[Field: %s] [Value: %s] [Message: %s]",
                    violation.getPropertyPath(), violation.getInvalidValue(), violation.getMessage()));
        }
    }

    @Test
    public void testPLDTStaffPromoAccountRequest() {

        this.violations = localValidatorFactory.validate(user);

        Assert.assertTrue("Expected validation error not found", violations.size() == 0);
    }
}
