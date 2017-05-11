package com.yourpc.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yourpc.dao.CategoryDao;
import com.yourpc.entity.Category;
import com.yourpc.entity.Item;

@Repository
public class CategoryDaoImpl extends GenericDaoImpl<Category, String> implements CategoryDao
{
	public CategoryDaoImpl()
	{
		super(Category.class);
	}

	@Override
	public void delete(String fieldName, String fieldValue) 
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
