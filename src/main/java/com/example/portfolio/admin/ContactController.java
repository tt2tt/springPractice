package com.example.portfolio.admin;

import com.example.portfolio.domain.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("admin")
public class ContactController {
    private final ContactService contactService;

    @GetMapping("contactIndex")
    public String contactIndex(Model model){
        model.addAttribute("contactForm", contactService.contactIndex());
        return "admin/contactIndex";
    }

}
