package com.example.portfolio.user;

import com.example.portfolio.domain.UserForm;
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

import java.util.Map;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private Map<String,String> statusRadio;
    private Map<String,String> genderRadio;

    @GetMapping("userSettingForm")
    public String userSettingForm(@AuthenticationPrincipal UserDetails user, UserSettingForm form, Model model){
        form = userService.createUserSettingForm(user.getUsername());
        model.addAttribute(form);
        return "user/userSettingForm";
    }

    @GetMapping("userEditForm")
    public String userEditForm(@AuthenticationPrincipal UserDetails user, UserForm form, Model model){
        form = userService.createGeneralUserEditForm(user.getUsername());
        model.addAttribute(form);
        statusRadio = userService.statusRadio();
        model.addAttribute("statusRadio",statusRadio);
        genderRadio = userService.genderRadio();
        model.addAttribute("genderRadio",genderRadio);
        form.setStatus(UserForm.Status.valueOf("valid"));
        form.setGender(UserForm.Gender.valueOf("man"));

        return "user/userEditForm";
    }

    @PostMapping("userSetting")
    public String userSetting(@Validated UserSettingForm form, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "user/userSettingForm";
        }
        userService.generalUserSetting(form.getId(), form.getEmail(),form.getPassword());
        return "index";
    }

    @PostMapping("userEdit")
    public String userEdit(@Validated UserForm form, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            statusRadio = userService.statusRadio();
            model.addAttribute("statusRadio",statusRadio);
            genderRadio = userService.genderRadio();
            model.addAttribute("genderRadio",genderRadio);
            form.setStatus(UserForm.Status.valueOf("valid"));
            form.setGender(UserForm.Gender.valueOf("man"));
            return "user/userEditForm";
        }
        byte[] profileImage = userService.uploadFile(form.getProfileImage());
        userService.userUpdate(form.getId(), form.getKana(), form.getName() , profileImage, form.getStatus(), form.getGender(), Integer.parseInt(form.getAge()), form.getSelfIntroduction());
        return "index";
    }
}
