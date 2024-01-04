package com.example.portfolio.infrastructure;

import com.example.portfolio.domain.Category;
import com.example.portfolio.domain.CategoryForm;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryRepository {
    @Select("select * from categories")
    List<Category> findAll();
    @Select("select * from categories where id = #{id}")
    CategoryForm createCategoryEditForm(Integer id);
    @Insert("insert into categories (name) values (#{name})")
    void categoryCreate(String name);
    @Update("UPDATE categories SET name = #{name} WHERE id = #{id}")
    void categoryUpdate(Integer id, String name);
    @Delete("DELETE FROM categories WHERE id = #{id}")
    void categoryDelete(Integer id);
}
