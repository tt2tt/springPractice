package com.example.portfolio.free;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/")
    public String userIndex(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
