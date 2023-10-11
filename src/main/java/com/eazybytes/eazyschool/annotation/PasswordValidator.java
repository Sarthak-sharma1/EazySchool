package com.eazybytes.eazyschool.annotation;

import com.eazybytes.eazyschool.validations.PasswordStrengthValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordStrengthValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordValidator {

    String message() default "Please Choose a Strong Password";
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
