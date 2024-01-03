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
    @Size(max=255,message = "255字以内で入力して下さい。")
    @Pattern(regexp = "^([\\u3040-\\u309F]+$)?$",message = "ひらがなを入力して下さい。")
    private String kana;
    @Size(max=255,message = "255字以内で入力して下さい。")
    private String name;
    @Size(max=255,message = "255字以内で入力して下さい。")
    @Pattern(regexp = "^[\\w!#%&'/=~`\\*\\+\\?\\{\\}\\^\\$\\-\\|]+(\\.[\\w!#%&'/=~`\\*\\+\\?\\{\\}\\^\\$\\-\\|]+)*@[\\w!#%&'/=~`\\*\\+\\?\\{\\}\\^\\$\\-\\|]+(\\.[\\w!#%&'/=~`\\*\\+\\?\\{\\}\\^\\$\\-\\|]+)*$",message = "メールアドレスのフォーマットで入力して下さい。")
    private String email;
    @Size(min=8,max=32,message = "8文字以上32文字以下で入力して下さい。")
    @Pattern(regexp = "[0-9a-zA-Z\\\\-\\\\_]+",message = "半角英数字とアンダースコアとハイフンのみで入力して下さい。")
    private String password;
    private Status status;
    @com.example.portfolio.validation.Gender
    private Gender gender;
    @Size(max=3,message = "3桁以下で入力して下さい。")
    @Pattern(regexp = "^([0-9])?$",message = "半角数字を入力して下さい。")
    private String age;
    @Size(max=1500,message = "1500文字以下で入力して下さい。")
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
