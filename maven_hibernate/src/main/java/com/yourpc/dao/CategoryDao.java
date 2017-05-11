package com.yourpc.dao;

import com.yourpc.entity.Category;
import com.yourpc.entity.Item;

public interface CategoryDao extends GenericDao<Category, Integer>
{
	void addItemToCategory(Category category, Item item);
}
