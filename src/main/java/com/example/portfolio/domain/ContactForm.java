package com.example.portfolio.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ContactForm {
    Integer id;
    String category;
    String content;
    Status status;

    public enum Status{
        incomplete,ongoing,completion
    }

}
