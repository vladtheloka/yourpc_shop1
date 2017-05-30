package com.yourpc.serviceimpl;

import java.util.List;

import com.yourpc.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

	private final Validator validator;

	@Autowired
	public CategoryServiceImpl(CategoryDao categoryDao, ItemDao itemDao, @Qualifier("categoryValidator") Validator validator)
	{
		this.categoryDao = categoryDao;
		this.itemDao = itemDao;
		this.validator = validator;
	}

	public void add(Category category) throws Exception
    {
	    validator.validate(category);
		categoryDao.save(category);
	}

	public void delete(int id)
	{
		Category category = categoryDao.categoryWithItems(id);

		for (Item item : category.getItem())
		{
			item.setCategory(null);
			itemDao.saveAndFlush(item);
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
}
