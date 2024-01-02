package com.example.portfolio.domain;

import com.example.portfolio.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public List<User> findByInvalidUser(){
        return userRepository.findByInvalidUser();
    }

    public UserSettingForm createUserSettingForm(String name) {return userRepository.createUserSettingForm(name);}

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

    public void createGeneralUser(String kana, String name, String email, String password, byte[] profileImage, UserForm.Status status, UserForm.Gender gender,Integer age, String selfIntroduction, UserForm.Authority authority) {userRepository.createGeneralUser(kana,name,email,password,profileImage,status,gender,age,selfIntroduction,authority);}

    public void adminUserSetting(Integer id, String name, String email, String password) {userRepository.adminUserSetting(id,name,email,password);}
    public void statusChange(Integer id, String status) {userRepository.statusChange(id,status);}

    public void delete(Integer id) {userRepository.delete(id);}
}
