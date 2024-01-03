package com.example.portfolio.domain;

import com.example.portfolio.infrastructure.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public void categoryCreate(String name) {categoryRepository.categoryCreate(name);}
}
