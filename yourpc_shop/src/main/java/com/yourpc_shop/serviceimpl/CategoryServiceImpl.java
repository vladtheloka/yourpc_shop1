package com.yourpc_shop.serviceimpl;

import java.util.List;

import com.yourpc_shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yourpc_shop.dao.CategoryDao;
import com.yourpc_shop.dao.ItemDao;
import com.yourpc_shop.entity.Category;
import com.yourpc_shop.entity.Item;
import com.yourpc_shop.service.CategoryService;

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

    public void add(Category category){
//        validator.validate(category);
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

    public void update(String categoryInfo)
    {
        Category category = categoryDao.findOne(Integer.parseInt(categoryInfo.split("_")[1]));
        category.setName(categoryInfo.split("_")[0]);
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