package com.example.portfolio.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserForm {
    private Integer id;
    private Status status;

    public enum Status{
        valid,invalid
    }
}
