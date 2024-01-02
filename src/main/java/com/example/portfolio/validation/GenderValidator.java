package com.example.portfolio.validation;

import com.example.portfolio.domain.UserForm;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

public class GenderValidator implements ConstraintValidator<Gender, UserForm.Gender> {

    @Override
    public boolean isValid(UserForm.Gender gender, ConstraintValidatorContext context){
        if (gender == null){
            return false;
        }
        return true;
    }
}
