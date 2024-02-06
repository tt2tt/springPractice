package com.example.portfolio.domain;

import com.example.portfolio.infrastructure.GoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoodService {
    private final GoodRepository goodRepository;
    public void cretaeGood(String name, Integer partnerId) {goodRepository.cretaeGood(name, partnerId);}
    public void goodCountUp(Integer goodsCount, Integer partnerId) {goodRepository.goodCountUp(goodsCount, partnerId);}
}
