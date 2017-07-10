package com.internetshop.dao;

import com.internetshop.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by admin on 05.07.2017.
 */
public interface CategoriesDao extends JpaRepository<Categories, Integer> {
    @Query ("select c from Categories c left join fetch c.commodities where c.id=:id")
    Categories categoriesWithCommodity(@Param("id") int id);
}
