package com.yourpc.service;

import java.util.List;

import com.yourpc.entity.Billable;
import com.yourpc.entity.Category;
import com.yourpc.entity.Item;

public interface ItemService
{
	void add(Item item);
	void delete(int id);
    void update(Item item);
	Item getOne(int id);
	List<Item> getAll();
	void addCategoyToItem(Category category, Item item);
	void addBillableToItem(Billable billable, Item item);
	Item getItemWithBillables(String itemName);
	void removeCategoryFromItem(Item item);
	Item findByName(String name);
	void deleteByName(String name);
}
