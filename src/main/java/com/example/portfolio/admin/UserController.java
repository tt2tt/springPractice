package com.example.portfolio.admin;

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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private Map<String,String> statusRadio;
    private Map<String,String> authorityRadio;
    private Map<String,String> genderRadio;

    @GetMapping("userIndex")
    public String validUsersIndex(Model model){
        model.addAttribute("userList", userService.findAll());
        return ("admin/userIndex");
    }

    @GetMapping("invalidUserIndex")
    public String invalidUsersIndex(Model model){
        model.addAttribute("invalidUserList", userService.findByInvalidUser());
     return ("admin/invalidUserIndex");
    }

    @GetMapping("userCreateForm")
    public String userCreateForm(UserForm form,Model model){
        statusRadio = userService.statusRadio();
        model.addAttribute("statusRadio",statusRadio);
        authorityRadio = userService.authorityRadio();
        model.addAttribute("authorityRadio",authorityRadio);
        genderRadio = userService.genderRadio();
        model.addAttribute("genderRadio",genderRadio);
        form.setStatus(UserForm.Status.valueOf("valid"));
        form.setAuthority(UserForm.Authority.valueOf("admin"));
        form.setGender(UserForm.Gender.valueOf("man"));

        return ("admin/userCreateForm");
    }

    @GetMapping("userSettingForm")
    public String userSetting(@AuthenticationPrincipal UserDetails user, UserSettingForm form, Model model){
        form = userService.createUserSettingForm(user.getUsername());
        model.addAttribute(form);
        return ("admin/userSettingForm");
    }

    @GetMapping("userEditForm/{userId}")
    public String userEdit(@PathVariable("userId") String userId,UserForm form,Model model){
        form = userService.createUserEditForm(Integer.parseInt(userId));
        model.addAttribute(form);
        statusRadio = userService.statusRadio();
        model.addAttribute("statusRadio",statusRadio);
        authorityRadio = userService.authorityRadio();
        model.addAttribute("authorityRadio",authorityRadio);
        genderRadio = userService.genderRadio();
        model.addAttribute("genderRadio",genderRadio);
        form.setStatus(UserForm.Status.valueOf("valid"));
        form.setAuthority(UserForm.Authority.valueOf("admin"));
        form.setGender(UserForm.Gender.valueOf("man"));
        return  "admin/userEditForm";
    }

    @PostMapping("userCreate")
    public String userCreate(@Validated UserForm form, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute(form);
            statusRadio = userService.statusRadio();
            model.addAttribute("statusRadio",statusRadio);
            authorityRadio = userService.authorityRadio();
            model.addAttribute("authorityRadio",authorityRadio);
            genderRadio = userService.genderRadio();
            model.addAttribute("genderRadio",genderRadio);
            form.setStatus(UserForm.Status.valueOf("valid"));
            form.setAuthority(UserForm.Authority.valueOf("admin"));
            form.setGender(UserForm.Gender.valueOf("man"));
            return ("admin/userCreateForm");
        }
        if (form.getAuthority().toString().equals("admin")){
            userService.createAdminUser(form.getName(),form.getEmail(),form.getPassword(),form.getStatus(),form.getAuthority());
        }else{
            byte[] profileImage = userService.uploadFile(form.getProfileImage());
            userService.createGeneralUser(form.getKana(),form.getName(),form.getEmail(),form.getPassword(),profileImage,form.getStatus(),form.getGender(),Integer.parseInt(form.getAge()),form.getSelfIntroduction(),form.getAuthority());
        }
        return "redirect:/admin/userIndex";
    }

    @PostMapping("userSetting")
    public String userSetting(@Validated UserSettingForm form, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ("admin/userSettingForm");
        }
        userService.adminUserSetting(form.getId(), form.getName(),form.getEmail(),form.getPassword());
        return "redirect:/admin/userIndex";
    }

    @PostMapping("userEdit")
    public String userEdit(@Validated UserForm form, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute(form);
            statusRadio = userService.statusRadio();
            model.addAttribute("statusRadio",statusRadio);
            authorityRadio = userService.authorityRadio();
            model.addAttribute("authorityRadio",authorityRadio);
            genderRadio = userService.genderRadio();
            model.addAttribute("genderRadio",genderRadio);
            form.setStatus(UserForm.Status.valueOf("valid"));
            form.setAuthority(UserForm.Authority.valueOf("admin"));
            form.setGender(UserForm.Gender.valueOf("man"));
            return ("admin/userEditForm");
        }
        if (form.getAuthority().toString().equals("admin")){
            userService.adminUserUpdate(form.getId(), form.getName(),form.getEmail(),form.getPassword(),form.getStatus());
        }else{
            byte[] profileImage = userService.uploadFile(form.getProfileImage());
            userService.generalUserUpdate(form.getId(),form.getKana(),form.getName(),form.getEmail(),form.getPassword(),profileImage,form.getStatus(),form.getGender(),Integer.parseInt(form.getAge()),form.getSelfIntroduction(),form.getAuthority());
        }

        return "redirect:/admin/userIndex";
    }

    @PostMapping("changeStatus")
    public String changeStatus(UserForm form){
        if (form.getStatus().toString().equals("valid")){
            userService.statusChange(form.getId(), "invalid");
        }else{
            userService.statusChange(form.getId(), "valid");
        }
        return "redirect:/admin/userIndex";
    }

    @PostMapping("restoration")
    public String restoration(UserForm form){
        userService.statusChange(form.getId(), "valid");
        return "redirect:/admin/invalidUserIndex";
    }

    @PostMapping("delete")
    public String delete(UserForm form){
        userService.delete(form.getId());
        return "redirect:/admin/invalidUserIndex";
    }
}
