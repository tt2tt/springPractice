package com.example.portfolio.domain;

import com.example.portfolio.infrastructure.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public List<Category> findAll() {return categoryRepository.findAll();}
    public CategoryForm createCategoryEditForm(Integer id) {return categoryRepository.createCategoryEditForm(id);}
    public void categoryCreate(String name) {categoryRepository.categoryCreate(name);}
    public void categoryUpdate(Integer id, String name) {categoryRepository.categoryUpdate(id,name);}
    public void categoryDelete(Integer id) {categoryRepository.categoryDelete(id);}
}
