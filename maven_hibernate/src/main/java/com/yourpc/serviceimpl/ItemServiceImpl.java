package com.yourpc.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yourpc.dao.GenericDao;
import com.yourpc.dao.ItemDao;
import com.yourpc.entity.Billable;
import com.yourpc.entity.Category;
import com.yourpc.entity.Item;
import com.yourpc.service.ItemService;

@Service
public class ItemServiceImpl extends GenericServiceImpl<Item, String> implements ItemService
{
	private ItemDao itemDao;
	
	@Autowired
	public ItemServiceImpl(
			@Qualifier("itemDaoImpl")GenericDao<Item, String> genericDao) 
	{
		super(genericDao);
		this.itemDao = (ItemDao) genericDao;
	}

	@Override
	public void addCategoyToItem(Category category, Item item)
	{
		itemDao.addCategoyToItem(category, item);
	}

	@Override
	public void addBillableToItem(Billable billable, Item item)
	{
		itemDao.addBillableToItem(billable, item);
	}

	@Override
	public Item getItemWithBillables(String itemName) 
	{
		return itemDao.getItemWithBillables(itemName);
	}

	@Override
	public void removeCategoryFromItem(Item item) 
	{
		itemDao.removeCategoryFromItem(item);
	}
}
