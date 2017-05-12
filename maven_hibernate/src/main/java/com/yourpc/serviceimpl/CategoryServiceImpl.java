package com.yourpc.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yourpc.dao.CategoryDao;
import com.yourpc.dao.GenericDao;
import com.yourpc.entity.Category;
import com.yourpc.service.CategoryService;

@Service
public class CategoryServiceImpl extends GenericServiceImpl<Category, String> implements CategoryService
{
	private CategoryDao categoryDao;

	@Autowired
	public CategoryServiceImpl(
			@Qualifier("categoryDaoImpl")GenericDao<Category, String> genericDao) 
	{
		super(genericDao);
		this.categoryDao = (CategoryDao) genericDao;
	}
}
