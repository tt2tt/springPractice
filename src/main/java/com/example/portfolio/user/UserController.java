package com.example.portfolio.user;

import com.example.portfolio.domain.UserService;
import com.example.portfolio.domain.UserSettingForm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("userSettingForm")
    public String userSettingForm(@AuthenticationPrincipal UserDetails user, UserSettingForm form, Model model){
        form = userService.createUserSettingForm(user.getUsername());
        model.addAttribute(form);
        return "user/userSettingForm";
    }

    @PostMapping("userSetting")
    public String userSetting(@Validated UserSettingForm form, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "user/userSettingForm";
        }
        userService.generalUserSetting(form.getId(), form.getEmail(),form.getPassword());
        return "index";
    }
}
