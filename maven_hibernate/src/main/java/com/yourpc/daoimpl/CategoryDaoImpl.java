package com.yourpc.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yourpc.dao.CategoryDao;
import com.yourpc.entity.Category;
import com.yourpc.entity.Item;

@Repository
public class CategoryDaoImpl extends GenericDaoImpl<Category, Integer> implements CategoryDao
{
	public CategoryDaoImpl() {
		super(Category.class);
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public void addItemToCategory(Category category, Item item) 
	{
		item.setCategory(category);
	}

	@Override
	public void delete(Integer fieldName, Integer fieldValue) 
	{
		Category category = super.getOne(fieldName, fieldValue);
		List<Item> items = category.getItem();
		for (Item item : items) 
		{
			item.setCategory(null);
			getEntityManager().merge(item);
		}
		super.delete(fieldName, fieldValue);
	}
}
