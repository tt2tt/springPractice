package com.example.portfolio.domain;

import com.example.portfolio.validation.Gender;
import com.example.portfolio.validation.ProfileImageSize;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Text;

@Data
@RequiredArgsConstructor
public class UserForm {
    private Integer id;
    @Size(min=1,max=255)
    @Pattern(regexp = "^[\\u3040-\\u309F]+$")
    private String kana;
    @NotBlank
    @Size(min=1,max=255)
    private String name;
    @NotBlank
    @Size(min=1,max=255)
    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$")
    private String email;
    @NotBlank
    @Size(min=8,max=32)
    private String password;
    private Status status;
    @com.example.portfolio.validation.Gender
    private Gender gender;
    @Size(min=1,max=3)
    @Pattern(regexp = "[0-9]+")
    private String age;
    @Size(min=1,max=1500)
    private String selfIntroduction;
    private Authority authority;
    @ProfileImageSize
    private MultipartFile profileImage;

    public enum Status{
        valid,invalid
    }

    public enum Authority{
        admin,user
    }

    public enum Gender{
        man,woman
    }
}
