package com.example.portfolio.infrastructure;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryRepository {
    @Insert("insert into categories (name) values (#{name})")
    void categoryCreate(String name);
}
