package com.example.portfolio.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserForm {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private Status status;
    private Authority authority;

    public enum Status{
        valid,invalid
    }

    public enum Authority{
        admin,user
    }
}
