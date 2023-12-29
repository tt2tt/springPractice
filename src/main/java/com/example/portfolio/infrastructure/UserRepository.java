package com.example.portfolio.infrastructure;

import com.example.portfolio.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
}
