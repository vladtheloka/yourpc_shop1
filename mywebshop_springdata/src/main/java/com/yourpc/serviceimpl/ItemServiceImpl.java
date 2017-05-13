package com.yourpc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourpc.dao.ItemDao;
import com.yourpc.entity.Item;
import com.yourpc.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService
{
	@Autowired
	private ItemDao itemDao;

	@Override
	public void add(Item item) 
	{
		itemDao.save(item);
	}

	@Override
	public void delete(int id) 
	{
		itemDao.delete(id);
	}

	@Override
	public void update(Item item)
	{
		itemDao.save(item);	
	}

	@Override
	public Item getOne(int id) 
	{
		return itemDao.findOne(id);
	}

	@Override
	public List<Item> getAll()
	{
		return itemDao.findAll();
	}

}
