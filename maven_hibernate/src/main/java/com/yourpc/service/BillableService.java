package com.yourpc.service;

import com.yourpc.entity.Billable;
import com.yourpc.entity.Item;
import com.yourpc.entity.User;

public interface BillableService extends GenericService<Billable, String>
{
	void addUserToBillable(User user, Billable billable);
	void addBillableToItem(Item item, Billable billable);
	Billable getBillablewithItems(String billableName);
	void removeUserFromBillable(Billable billable);
}
