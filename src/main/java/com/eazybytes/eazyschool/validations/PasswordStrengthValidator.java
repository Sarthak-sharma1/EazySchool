package com.eazybytes.eazyschool.validations;

import com.eazybytes.eazyschool.annotation.PasswordValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class PasswordStrengthValidator implements ConstraintValidator<PasswordValidator,String> {

    List<String> weakPasswords;
    @Override
    public void initialize(PasswordValidator passwordValidator) {
       weakPasswords = Arrays.asList("123456","password","qwerty","123456789","111111","1q2w3e");
    }

    @Override
    public boolean isValid(String passwordField, ConstraintValidatorContext context) {
        return passwordField != null && (!weakPasswords.contains(passwordField));
    }
}
