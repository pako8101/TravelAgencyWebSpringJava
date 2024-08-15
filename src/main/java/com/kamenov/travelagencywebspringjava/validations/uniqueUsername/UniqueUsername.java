package com.kamenov.travelagencywebspringjava.validations.uniqueUsername;

import com.kamenov.travelagencywebspringjava.validations.uniqueEmail.UniqueEmailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueUsernameValidator.class)
public @interface UniqueUsername {
    String message() default "Please write unique username";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
