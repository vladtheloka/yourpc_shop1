package com.internetshop.service;

import com.internetshop.entity.Categories;

import java.util.List;

/**
 * Created by admin on 05.07.2017.
 */
public interface CategoriesService {

    void save (Categories categories);
    List<Categories> findAll();
    Categories findOne(int id);
    void delete (int id);
    void update (String categoryInfo);

}
