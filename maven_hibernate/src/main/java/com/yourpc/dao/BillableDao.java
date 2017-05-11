package com.yourpc.dao;

import com.yourpc.entity.Billable;
import com.yourpc.entity.Item;
import com.yourpc.entity.User;

public interface BillableDao extends GenericDao<Billable, String>
{
	void addUserToBillable(User user, Billable billable);
	void addBillableToItem(Item item, Billable billable);
}
