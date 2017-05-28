package com.yourpc.service;

import java.util.List;
import java.util.Set;

import com.yourpc.entity.Billable;
import com.yourpc.entity.Item;
import com.yourpc.entity.User;

public interface BillableService
{
	void add(Billable billable);
	void delete(int id);
    void update(Billable billable);
	Billable getOne(int id);
	List<Billable> getAll();
	void addUserToBillable(User user, Billable billable);
	void addBillableToItem(Item item, Billable billable);
	Billable getBillableWithItems(int id);
	void removeUserFromBillable(Billable billable);
	Billable findByName(String name);
	void deleteByName(String name);
	Set<Item> getBillableWithItems();
}
