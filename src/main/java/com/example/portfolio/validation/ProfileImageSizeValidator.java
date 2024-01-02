package com.example.portfolio.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

public class ProfileImageSizeValidator implements ConstraintValidator<ProfileImageSize, MultipartFile> {

    @Override
    public boolean isValid(MultipartFile profileImage, ConstraintValidatorContext context){
        if (profileImage.getSize() < 2097152){
            return true;
        }
        return false;
    }
}
