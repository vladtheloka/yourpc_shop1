package com.yourpc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourpc.entity.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryDao extends JpaRepository<Category, Integer>
{
    @Query("select c from Category c left join fetch c.item where c.id=:id")
	Category categoryWithItems(@Param("id") int id);
}
