package com.internetshop.controller;

import com.internetshop.dto.CategoriesDto;
import com.internetshop.dto.DtoUtilMapper;
import com.internetshop.entity.Categories;
import com.internetshop.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by admin on 07.07.2017.
 */
@RestController
public class CategoriesControllerRes {
    @Autowired
    private CategoriesService categoriesService;

    @PostMapping("/category")
    public List<CategoriesDto> saveCategory(@RequestBody Categories category){

        categoriesService.save(category);
        return DtoUtilMapper.categoriesToDtos(categoriesService.findAll());
    }
    @DeleteMapping("/category")
    public List<CategoriesDto> deleteCategory(@RequestBody String categoryId){
        categoriesService.delete(Integer.valueOf(categoryId));

        return DtoUtilMapper.categoriesToDtos(categoriesService.findAll());
    }
    @GetMapping("/category")
    public List<CategoriesDto> loadCategories(){
        return DtoUtilMapper.categoriesToDtos(categoriesService.findAll());
    }

    @PutMapping("/category")
    public List<CategoriesDto> updateCategory(@RequestBody String categoryInfo){
        categoriesService.update(categoryInfo);
        return DtoUtilMapper.categoriesToDtos(categoriesService.findAll());
    }



}
