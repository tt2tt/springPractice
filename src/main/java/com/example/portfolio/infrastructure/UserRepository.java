package com.example.portfolio.infrastructure;

import com.example.portfolio.domain.User;
import com.example.portfolio.domain.UserForm;
import com.example.portfolio.domain.UserSettingForm;
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
    @Select("select * from users where authority = 'user'")
    List<User> findGeneralUser();
    @Select("select * from users where name = #{name}")
    UserSettingForm createUserSettingForm(String name);
    @Select("select * from users where id = #{id}")
    UserForm createUserEditForm(Integer id);
    @Select("select * from users where name = #{name}")
    UserForm createGeneralUserEditForm(String name);
    @Insert("insert into users (kana, name, email, password, profileImage, status, gender, age, selfIntroduction, goodsCount, authority) values ('', #{name}, #{email}, #{password}, '', #{status}, 'man', '', '', 0, #{authority})")
    void createAdminUser(String name, String email, String password, UserForm.Status status, UserForm.Authority authority);
    @Insert("insert into users (kana, name, email, password, profileImage, status, gender, age, selfIntroduction, goodsCount, authority) values (#{kana}, #{name}, #{email}, #{password}, #{profileImage}, #{status}, #{gender}, #{age}, #{selfIntroduction}, 0, #{authority})")
    void createGeneralUser(String kana, String name, String email, String password, byte[] profileImage, UserForm.Status status, UserForm.Gender gender, Integer age, String selfIntroduction, UserForm.Authority authority);
    @Update("UPDATE users SET name = #{name}, email = #{email}, password = #{password}, status = #{status} WHERE id = #{id}")
    void adminUserUpdate(Integer id, String name, String email, String password, UserForm.Status status);
    @Update("UPDATE users SET kana = #{kana}, name = #{name}, email = #{email}, password = #{password}, profileImage = #{profileImage}, status = #{status}, gender = #{gender}, age = #{age}, selfIntroduction = #{selfIntroduction}, authority = #{authority} WHERE id = #{id}")
    void generalUserUpdate(Integer id, String kana, String name, String email, String password, byte[] profileImage, UserForm.Status status, UserForm.Gender gender, Integer age, String selfIntroduction, UserForm.Authority authority);
    @Update("UPDATE users SET kana = #{kana}, name = #{name}, profileImage = #{profileImage}, status = #{status}, gender = #{gender}, age = #{age}, selfIntroduction = #{selfIntroduction} WHERE id = #{id}")
    void userUpdate(Integer id, String kana, String name, byte[] profileImage, UserForm.Status status, UserForm.Gender gender, Integer age, String selfIntroduction);
    @Update("UPDATE users SET name = #{name}, email = #{email}, password = #{password} WHERE id = #{id}")
    void adminUserSetting(Integer id,String name, String email, String password);
    @Update("UPDATE users SET email = #{email}, password = #{password} WHERE id = #{id}")
    void generalUserSetting(Integer id, String email, String password);
    @Update("UPDATE users SET status = #{status} WHERE id = #{id}")
    void statusChange(Integer id, String status);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void delete(Integer id);
}
