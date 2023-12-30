package com.example.portfolio.domain;

import com.example.portfolio.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


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

    public void createAdminUser(String name, String email, String password, UserForm.Status status, UserForm.Authority authority) {userRepository.createAdminUser(name,email,password,status,authority);}

    public void statusChange(Integer id, String status) {userRepository.statusChange(id,status);}

    public void delete(Integer id) {userRepository.delete(id);}
}
