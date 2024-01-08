package com.example.portfolio.infrastructure;

import com.example.portfolio.domain.Contact;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ContactRepository {
    @Select("SELECT * FROM contacts")
    List<Contact> contactIndex();
    @Select("SELECT * FROM contacts WHERE id = #{id}")
    Contact contactShow(Integer id);
    @Insert("insert into contacts (category,content,status) values (#{category},#{content},'incomplete')")
    void contactCreate(String category, String content);
    @Update("UPDATE contacts SET status = #{status} WHERE id = #{id}")
    void contactStatusChange(Integer id, String status);
}
