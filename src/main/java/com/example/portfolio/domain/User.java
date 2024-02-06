package com.example.portfolio.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String kana;
    private String name;
    private String email;
    private String status;
    private String password;
    private byte[] profileImage;
    private String gender;
    private Integer age;
    private String selfIntroduction;
    private String authority;
    private String image;
    private String goodsCount;

}
