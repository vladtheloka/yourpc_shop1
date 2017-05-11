package com.yourpc.daoimpl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yourpc.dao.ItemDao;
import com.yourpc.entity.Billable;
import com.yourpc.entity.Category;
import com.yourpc.entity.Item;

@Repository
public class ItemDaoImpl extends GenericDaoImpl<Item, Integer> implements ItemDao
{
	
	public ItemDaoImpl() {
		super(Item.class);
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public void addCategoyToItem(Category category, Item item)
	{
		item.setCategory(category);
	}
	
	@Transactional
	public void addBillableToItem(Billable billable, Item item) 
	{
		item.getBillable().add(billable);
		getEntityManager().merge(item);
	}
}
