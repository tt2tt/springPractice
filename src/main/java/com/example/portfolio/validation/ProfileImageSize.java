package com.example.portfolio.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProfileImageSizeValidator.class)
public @interface ProfileImageSize {
    String message() default "2MB以内の画像をアップロードして下さい。";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
