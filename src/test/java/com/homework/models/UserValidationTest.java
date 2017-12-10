package com.homework.models;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class UserValidationTest {
    private static Validator validator;

    @Before
    public static void main(String[] args) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    public void testValidPasswordUser() {
        AppUser user = new AppUser();
        user.setPassword("");
        Set<ConstraintViolation<AppUser>> violations = validator.validate(user);
        assertEquals(1, violations.size());
    }

    @Test
    public void testValidFirstnameUser() {
        AppUser user = new AppUser();
        user.setFirstName("");
        Set<ConstraintViolation<AppUser>> violations = validator.validate(user);
        assertEquals(1, violations.size());
    }

    @Test
    public void testValidLastnameUser() {
        AppUser user = new AppUser();
        user.setLastName("");
        Set<ConstraintViolation<AppUser>> violations = validator.validate(user);
        assertEquals(1, violations.size());
    }

    @Test
    public void testValidRolesUser() {
        AppUser user = new AppUser();
        user.setRole(null);
        Set<ConstraintViolation<AppUser>> violations = validator.validate(user);
        assertEquals(1, violations.size());
    }

    @Test
    public void testValidEmailUser() {
        AppUser user = new AppUser();
        user.setEmail("pasha.com");
        Set<ConstraintViolation<AppUser>> violations = validator.validate(user);
        assertEquals(1, violations.size());
    }
}
