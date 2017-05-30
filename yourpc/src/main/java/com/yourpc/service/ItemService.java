package com.yourpc.service;

import java.util.List;

import com.yourpc.entity.Item;

public interface ItemService
{
	void add(Item item) throws Exception;
	void delete(int id);
    void update(Item item);
	Item getOne(int id);
	List<Item> getAll();
}
