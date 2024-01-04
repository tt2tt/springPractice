package com.example.portfolio.infrastructure;

import com.example.portfolio.domain.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryRepository {
    @Select("select * from categories")
    List<Category> findAll();
    @Insert("insert into categories (name) values (#{name})")
    void categoryCreate(String name);
}
