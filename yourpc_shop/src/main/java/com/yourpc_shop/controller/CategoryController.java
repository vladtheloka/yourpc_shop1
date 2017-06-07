package com.yourpc_shop.controller;

import com.yourpc_shop.entity.Category;
import com.yourpc_shop.service.CategoryService;
import com.yourpc_shop.validator.category.CategoryValidationMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Transactional
public class CategoryController
{
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public String addCategory(Model model)
    {
        model.addAttribute("category", new Category());
        return "views-admin-category";
    }

    @PostMapping("/saveCategory")
    public String addCategory(@ModelAttribute Category category, Model model)
    {
        try
        {
            categoryService.add(category);
        }
        catch (Exception e)
        {
            if(e.getMessage().equals(CategoryValidationMessages.EMPTY_CATEGORY_FIELD))
            {
                model.addAttribute("categoryException", e.getMessage());
            }
            return "views-admin-category";
        }
        return "redirect:/";
    }

    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable int id)
    {
        categoryService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/updateCategory/{id}")
    public String getCategory(@PathVariable int id, Model model)
    {
        model.addAttribute("categoryAttribute", categoryService.getOne(id));
        return "views-admin-updateCategory";
    }

    @PostMapping("/updateCategory/{id}")
    public  String updateRole(@ModelAttribute Category category, @PathVariable int id, Model model)
    {
        category.setId(id);
        categoryService.update(category);
        model.addAttribute("categories", categoryService.getAll());
        return "redirect:/";
    }

    @GetMapping("/listOfCategories")
    public String allItems(Model model)
    {
        model.addAttribute("categories", categoryService.getAll());
        return "views-admin-listOfCategories";
    }
}
