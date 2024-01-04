package com.example.portfolio.admin;

import com.example.portfolio.domain.CategoryForm;
import com.example.portfolio.domain.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("categoryIndex")
    public String categoryIndex(Model model){
        model.addAttribute("categoryForm", categoryService.findAll());
        return "admin/categoryIndex";
    }
    @GetMapping("categoryCreateForm")
    public String categoryCreateForm(CategoryForm form){
        return "admin/categoryCreateForm";
    }

    @PostMapping("categoryCreate")
    public String categoryCreate(@Validated CategoryForm form, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "admin/categoryCreateForm";
        }
        categoryService.categoryCreate(form.getName());
        return "redirect:/admin/userIndex";
    }
}
