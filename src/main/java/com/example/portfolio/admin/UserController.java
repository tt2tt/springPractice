package com.example.portfolio.admin;

import com.example.portfolio.domain.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/validIndex")
    public String validUsersIndex(Model model){
        model.addAttribute("validUserList", userService.findAll());
        return ("admin/validIndex");
    }
}
