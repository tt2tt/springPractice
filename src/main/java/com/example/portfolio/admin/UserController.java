package com.example.portfolio.admin;

import com.example.portfolio.domain.UserForm;
import com.example.portfolio.domain.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private Map<String,String> radioGender;
    private Map<String,String> statusRadio(){
        Map<String,String> statusRadio = new LinkedHashMap<>();
        statusRadio.put("valid","アクセス許可");
        statusRadio.put("invalid","アクセス禁止");
        return statusRadio;
    }
    private Map<String,String> authorityRadio(){
        Map<String,String> authorityRadio = new LinkedHashMap<>();
        authorityRadio.put("admin","管理者");
        authorityRadio.put("user","一般");
        return authorityRadio;
    }

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
        radioGender = statusRadio();
        model.addAttribute("statusRadio",radioGender);
        radioGender = authorityRadio();
        model.addAttribute("authorityRadio",radioGender);

        form.setStatus(UserForm.Status.valueOf("valid"));
        form.setAuthority(UserForm.Authority.valueOf("admin"));
        return ("admin/userCreateForm");
    }

    @PostMapping("userCreate")
    public String userCreate(UserForm form){
        userService.createAdminUser(form.getName(),form.getEmail(),form.getPassword(),form.getStatus(),form.getAuthority());
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
