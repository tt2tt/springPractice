package com.example.portfolio.infrastructure;

import com.example.portfolio.domain.User;
import com.example.portfolio.domain.UserForm;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserRepository {
    @Select("select * from users where name = #{name}")
    Optional<User> findByLoginUser(String name);

    @Select("select * from users")
    List<User> findAll();

    @Select("select * from users where status = 'invalid'")
    List<User> findByInvalidUser();

    @Update("UPDATE users SET status = #{status} WHERE id = #{id}")
    void statusChange(Integer id, String status);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void delete(Integer id);
}
