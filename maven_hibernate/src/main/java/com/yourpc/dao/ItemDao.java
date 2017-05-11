package com.yourpc.dao;

import com.yourpc.entity.Billable;
import com.yourpc.entity.Category;
import com.yourpc.entity.Item;

public interface ItemDao extends GenericDao<Item, String>
{
	void addCategoyToItem(Category category, Item item);
	void addBillableToItem(Billable billable, Item item);
}
