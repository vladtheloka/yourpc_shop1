package com.yourpc.service;

import java.util.List;

import com.yourpc.entity.Category;

public interface CategoryService
{
	void add(Category category);
	void delete(int id);
    void update(Category category);
	Category getOne(int id);
	List<Category> getAll();
}
