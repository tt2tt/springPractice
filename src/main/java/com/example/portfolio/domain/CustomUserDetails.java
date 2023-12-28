package com.example.portfolio.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.util.Collection;

public class CustomUserDetails extends User {
    public CustomUserDetails(String name, String password, Collection<? extends GrantedAuthority> authorities){
        super(name,password,authorities);
    }
}
