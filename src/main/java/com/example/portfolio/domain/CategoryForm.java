package com.example.portfolio.domain;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CategoryForm {
    Integer id;
    @Size(max=255,message = "255字以内で入力して下さい。")
    String name;
}
