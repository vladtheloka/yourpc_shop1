package com.yourpc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yourpc.entity.Item;

public interface ItemDao extends JpaRepository<Item, Integer>
{
	Item findByName(String name);
	void deleteByName(String name);
	@Query("select i from Item i left join fetch i.billable where i.name =:name")
	Item getItemWithBillables(@Param("name")String itemName);
}
