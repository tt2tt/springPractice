package com.example.portfolio.domain;

import com.example.portfolio.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Map<String,String> statusRadio(){
        Map<String,String> statusRadio = new LinkedHashMap<>();
        statusRadio.put("valid","アクセス許可");
        statusRadio.put("invalid","アクセス禁止");
        return statusRadio;
    }
    public Map<String,String> authorityRadio(){
        Map<String,String> authorityRadio = new LinkedHashMap<>();
        authorityRadio.put("admin","管理者");
        authorityRadio.put("user","一般");
        return authorityRadio;
    }

    public Map<String,String> genderRadio(){
        Map<String,String> genderRadio = new LinkedHashMap<>();
        genderRadio.put("man","男");
        genderRadio.put("woman","女");
        return genderRadio;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public List<User> findByInvalidUser(){
        return userRepository.findByInvalidUser();
    }

    public List<User> findGeneralUser() {return  userRepository.findGeneralUser();}

    public UserSettingForm createUserSettingForm(String name) {return userRepository.createUserSettingForm(name);}

    public UserForm createUserEditForm(Integer id) {return userRepository.createUserEditForm(id);}

    public UserForm createGeneralUserEditForm(String name) {return userRepository.createGeneralUserEditForm(name);}

    public byte[] uploadFile(MultipartFile multipartFile){
        try{
            byte[] bytes = multipartFile.getBytes();
            return bytes;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public void createAdminUser(String name, String email, String password, UserForm.Status status, UserForm.Authority authority) {userRepository.createAdminUser(name,email,password,status,authority);}
    public void createGeneralUser(String kana, String name, String email, String password, byte[] profileImage, UserForm.Status status, UserForm.Gender gender, Integer age, String selfIntroduction, UserForm.Authority authority) {userRepository.createGeneralUser(kana,name,email,password,profileImage,status,gender,age,selfIntroduction,authority);}
    public void adminUserUpdate(Integer id, String name, String email, String password, UserForm.Status status) {userRepository.adminUserUpdate(id,name,email,password, status);}
    public void generalUserUpdate(Integer id,String kana, String name, String email, String password, byte[] profileImage, UserForm.Status status, UserForm.Gender gender, Integer age, String selfIntroduction, UserForm.Authority authority) {userRepository.generalUserUpdate(id,kana,name,email,password,profileImage,status,gender,age,selfIntroduction,authority);}

    public void userUpdate(Integer id, String kana, String name, byte[] profileImage, UserForm.Status status, UserForm.Gender gender, Integer age, String selfIntroduction) {userRepository.userUpdate(id,kana,name,profileImage,status,gender,age,selfIntroduction);}
    public void adminUserSetting(Integer id, String name, String email, String password) {userRepository.adminUserSetting(id,name,email,password);}
    public void generalUserSetting(Integer id, String email, String password) {userRepository.generalUserSetting(id,email,password);}
    public void statusChange(Integer id, String status) {userRepository.statusChange(id,status);}

    public void delete(Integer id) {userRepository.delete(id);}
}
