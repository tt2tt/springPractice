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
    @GetMapping("/userIndex")
    public String validUsersIndex(Model model){
        model.addAttribute("userList", userService.findAll());
        return ("admin/userIndex");
    }

    @GetMapping("invalidUserIndex")
    public String invalidUsersIndex(Model model){
        model.addAttribute("invalidUserList", userService.findByInvalidUser());
     return ("admin/invalidUserIndex");
    }
}
