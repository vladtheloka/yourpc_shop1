package com.yourpc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourpc.dao.CategoryDao;
import com.yourpc.entity.Category;
import com.yourpc.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService
{
	@Autowired
	private CategoryDao categoryDao;

	public void add(Category category) 
	{
		categoryDao.save(category);
	}

	public void delete(int id)
	{
		categoryDao.delete(id);
	}

	public void update(Category category) 
	{
		categoryDao.save(category);
	}

	public Category getOne(int id) 
	{
		return categoryDao.findOne(id);
	}

	public List<Category> getAll() 
	{
		return categoryDao.findAll();
	}
}
