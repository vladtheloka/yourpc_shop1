package com.yourpc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourpc.dao.ItemDao;
import com.yourpc.entity.Billable;
import com.yourpc.entity.Category;
import com.yourpc.entity.Item;
import com.yourpc.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService
{
	@Autowired
	private ItemDao itemDao;

	public void add(Item item) 
	{
		itemDao.save(item);
	}

	public void delete(int id) 
	{
		itemDao.delete(id);
	}

	public void update(Item item)
	{
		itemDao.save(item);	
	}

	public Item getOne(int id) 
	{
		return itemDao.findOne(id);
	}

	public List<Item> getAll()
	{
		return itemDao.findAll();
	}

	public void addCategoyToItem(Category category, Item item) 
	{
		item.setCategory(category);
		itemDao.save(item);
	}

	public void addBillableToItem(Billable billable, Item item)
	{
		item.getBillable().add(billable);
		itemDao.save(item);
	}

	public Item getItemWithBillables(String itemName)
	{
		return itemDao.getItemWithBillables(itemName);
	}

	public void removeCategoryFromItem(Item item) 
	{
		item.setCategory(null);
		itemDao.save(item);
	}

	@Override
	public Item findByName(String name) 
	{
		return itemDao.findByName(name);
	}

	@Override
	public void deleteByName(String name)
	{
		itemDao.deleteByName(name);
	}

}
