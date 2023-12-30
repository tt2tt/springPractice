package com.example.portfolio.infrastructure;

import com.example.portfolio.domain.User;
import com.example.portfolio.domain.UserForm;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserRepository {
    @Select("select * from users where name = #{name} AND status ='valid'")
    Optional<User> findByLoginUser(String name);

    @Select("select * from users")
    List<User> findAll();

    @Select("select * from users where status = 'invalid'")
    List<User> findByInvalidUser();

    @Insert("insert into users (kana, name, email, password, profile_image, status, gender, age, self_introduction, goods_count, authority) values ('', #{name}, #{email}, #{password}, '', #{status}, 'man', '', '', 0, #{authority})")
    void createAdminUser(String name, String email, String password, UserForm.Status status, UserForm.Authority authority);

    @Update("UPDATE users SET status = #{status} WHERE id = #{id}")
    void statusChange(Integer id, String status);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void delete(Integer id);
}
