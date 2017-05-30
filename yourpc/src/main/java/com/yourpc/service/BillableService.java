package com.yourpc.service;

import java.util.List;
import java.util.Set;

import com.yourpc.entity.Billable;
import com.yourpc.entity.Item;

public interface BillableService
{
	void add(Billable billable) throws Exception;
	void delete(int id);
    void update(Billable billable);
	Billable getOne(int id);
	List<Billable> getAll();
	Set<Billable> getBillableWithItems();
}
