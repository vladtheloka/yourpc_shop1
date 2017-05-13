package com.yourpc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourpc.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>
{
	Category findByName(String name);
	void deleteByName(String name);
}
