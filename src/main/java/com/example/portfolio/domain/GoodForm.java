package com.example.portfolio.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GoodForm {
    private String name;
    private Integer goodsCount;
    private Integer partnerId;
}
