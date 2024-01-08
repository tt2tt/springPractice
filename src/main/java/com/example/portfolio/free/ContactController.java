package com.example.portfolio.free;

import com.example.portfolio.domain.CategoryForm;
import com.example.portfolio.domain.CategoryService;
import com.example.portfolio.domain.ContactForm;
import com.example.portfolio.domain.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;
    private final CategoryService categoryService;
    @GetMapping("contactCreateForm")
    public String contactForm(ContactForm form, Model model){
        model.addAttribute("categoryForm", categoryService.findAll());
        return ("contactCreateForm");
    }

    @PostMapping("contactCreate")
    public String contactCreate(ContactForm form){
        contactService.contactCreate(form.getCategory(),form.getContent());
        return "index";
    }
}
