package com.yourpc.serviceimpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourpc.dao.CategoryDao;
import com.yourpc.dao.ItemDao;
import com.yourpc.entity.Category;
import com.yourpc.entity.Item;
import com.yourpc.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService
{
	private final CategoryDao categoryDao;
	
	private final ItemDao itemDao;

	@Autowired
	public CategoryServiceImpl(CategoryDao categoryDao, ItemDao itemDao) {
		this.categoryDao = categoryDao;
		this.itemDao = itemDao;
	}

	public void add(Category category) 
	{
		categoryDao.save(category);
	}

	public void delete(int id)
	{
		Category category = categoryDao.findOne(id);
		
		Set<Item> items = category.getItem();
		for (Item i : items) 
		{
			i.setCategory(null);
			itemDao.save(i);
		}
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

	public Category findByName(String name)
	{
		return categoryDao.findByName(name);
	}

	public void deleteByName(String name)
	{
		categoryDao.deleteByName(name);
	}
}
