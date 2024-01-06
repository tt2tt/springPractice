package com.example.portfolio.infrastructure;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContactRepository {
    @Insert("insert into contacts (category,content,status) values (#{category},#{content},'incomplete')")
    void contactCreate(String category, String content);
}
