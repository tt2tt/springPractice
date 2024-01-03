package com.example.portfolio.domain;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserSettingForm {
    private Integer id;
    @Size(max=255,message = "255字以内で入力して下さい。")
    private String name;
    @Size(max=255,message = "255字以内で入力して下さい。")
    @Pattern(regexp = "^[\\w!#%&'/=~`\\*\\+\\?\\{\\}\\^\\$\\-\\|]+(\\.[\\w!#%&'/=~`\\*\\+\\?\\{\\}\\^\\$\\-\\|]+)*@[\\w!#%&'/=~`\\*\\+\\?\\{\\}\\^\\$\\-\\|]+(\\.[\\w!#%&'/=~`\\*\\+\\?\\{\\}\\^\\$\\-\\|]+)*$",message = "メールアドレスのフォーマットで入力して下さい。")
    private String email;
    @Size(min=8,max=32,message = "8文字以上32文字以下で入力して下さい。")
    @Pattern(regexp = "[0-9a-zA-Z\\\\-\\\\_]+",message = "半角英数字とアンダースコアとハイフンのみで入力して下さい。")
    private String password;
}
