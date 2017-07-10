package com.internetshop.serviseImpl;

import com.internetshop.dao.CategoriesDao;
import com.internetshop.dao.CommodityDao;
import com.internetshop.entity.Categories;
import com.internetshop.entity.Commodity;
import com.internetshop.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 05.07.2017.
 */
@Service
public class CategoriesServiceImpl implements CategoriesService {
    @Autowired
    private CategoriesDao categoriesDao;
    @Autowired
    private CommodityDao commodityDao;

    @Override
    public void save(Categories categories) {
        categoriesDao.save(categories);
    }

    @Override
    public List<Categories> findAll() {
        return categoriesDao.findAll();
    }

    @Override
    public Categories findOne(int id) {
        return categoriesDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        Categories categories = categoriesDao.categoriesWithCommodity(id);

        for (Commodity commodity: categories.getCommodities()
             ) {
            commodity.setCategories(null);
            commodityDao.saveAndFlush(commodity);
        }

        categoriesDao.delete(id);
    }

    @Override
    public void update(String categoryInfo) {
        Categories category = categoriesDao.findOne(Integer.parseInt(categoryInfo.split("_")[1]));
        category.setName(categoryInfo.split("_")[0]);
        categoriesDao.save(category);

        categoriesDao.save(category);

    }


}
