package com.example.portfolio.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Contact {
    Integer id;
    String category;
    String content;
    ContactForm.Status status;

    public enum Status{
        incomplete,ongoing,completion
    }
}
