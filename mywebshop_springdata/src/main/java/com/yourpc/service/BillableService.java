package com.yourpc.service;

import java.util.List;

import com.yourpc.entity.Billable;

public interface BillableService
{
	void add(Billable billable);
	void delete(int id);
    void update(Billable billable);
	Billable getOne(int id);
	List<Billable> getAll();
}
