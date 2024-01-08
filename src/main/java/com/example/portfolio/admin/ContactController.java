package com.example.portfolio.admin;

import com.example.portfolio.domain.Contact;
import com.example.portfolio.domain.ContactForm;
import com.example.portfolio.domain.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("contactShow/{contactId}")
    public String contactShow(@PathVariable("contactId") String contactId, Model model, ContactForm form){
        model.addAttribute("contactForm", contactService.contactShow(Integer.parseInt(contactId)));
        return "admin/contactShow";
    }

    @PostMapping("contactStatusChange")
    public String contactStatusChange(ContactForm form){
        contactService.contactStatusChange(form.getId(), form.getCategory());
        return "redirect:/admin/contactIndex";
    }

}
