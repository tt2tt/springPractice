package com.example.portfolio.free;

import com.example.portfolio.domain.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/")
    public String userIndex(Model model){
        model.addAttribute("userList", userService.findGeneralUser());
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
