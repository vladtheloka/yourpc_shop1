package com.yourpc_shop.service;

import java.util.List;

import com.yourpc_shop.entity.Category;

public interface CategoryService
{
    void add(Category category);
    void delete(int id);
    void update(String categoryInfo);
    Category getOne(int id);
    List<Category> getAll();
}
