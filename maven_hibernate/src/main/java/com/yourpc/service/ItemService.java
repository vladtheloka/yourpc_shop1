package com.yourpc.service;

import com.yourpc.entity.Billable;
import com.yourpc.entity.Category;
import com.yourpc.entity.Item;

public interface ItemService extends GenericService<Item, String>
{
	void addCategoyToItem(Category category, Item item);
	void addBillableToItem(Billable billable, Item item);
	Item getItemWithBillables(String itemName);
	void removeCategoryFromItem(Item item);
}
