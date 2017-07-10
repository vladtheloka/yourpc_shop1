package com.internetshop.controller;

import com.internetshop.entity.Categories;
import com.internetshop.service.CategoriesService;
import org.jboss.logging.annotations.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by admin on 05.07.2017.
 */
@Controller
public class CategoriesController {

    @GetMapping ("/addCategory")
    public String addCategory(){

    return "views-admin-categories";
}
//    @PostMapping("/addCategory")
//    public String saveCategory(Model model, @ModelAttribute Categories categories){
//        categoriesService.save(categories);
//        return "redirect:/addCategory";
//    }
//
//    @GetMapping("/deleteCategory/{id}")
//    public String deleteCategory(@PathVariable int id){
//        categoriesService.delete(id);
//        System.out.println("dfdf");
//        return "redirect:/addCategory";
//
//    }





}
