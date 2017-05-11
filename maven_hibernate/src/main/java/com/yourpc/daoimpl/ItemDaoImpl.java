package com.yourpc.daoimpl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yourpc.dao.ItemDao;
import com.yourpc.entity.Billable;
import com.yourpc.entity.Category;
import com.yourpc.entity.Item;

@Repository
public class ItemDaoImpl extends GenericDaoImpl<Item, String> implements ItemDao
{
	
	public ItemDaoImpl() 
	{
		super(Item.class);
	}

	@Transactional
	@Override
	public void addCategoyToItem(Category category, Item item)
	{
		item.setCategory(category);
		getEntityManager().merge(item);
	}
	
	@Transactional
	@Override
	public void addBillableToItem(Billable billable, Item item) 
	{
		item.getBillable().add(billable);
		getEntityManager().merge(item);
	}
}
