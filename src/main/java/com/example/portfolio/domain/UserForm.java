package com.example.portfolio.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.w3c.dom.Text;

@Data
@RequiredArgsConstructor
public class UserForm {
    private Integer id;
    private String kana;
    private String name;
    private String email;
    private String password;
    private Status status;
    private Gender gender;
    private Integer age;
    private String selfIntroduction;
    private Authority authority;

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
