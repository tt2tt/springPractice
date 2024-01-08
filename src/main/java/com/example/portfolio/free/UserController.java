package com.example.portfolio.free;

import com.example.portfolio.domain.User;
import com.example.portfolio.domain.UserForm;
import com.example.portfolio.domain.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Base64;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/")
    public String userIndex(Model model){
        model.addAttribute("userList", userService.findGeneralUser());
        return "index";
    }

    @GetMapping("userShow/{userId}")
    public String userShow(@PathVariable("userId") String userId, User user, Model model){
        user = userService.userShow(Integer.parseInt(userId));
        model.addAttribute(user);
        return "userShow";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
