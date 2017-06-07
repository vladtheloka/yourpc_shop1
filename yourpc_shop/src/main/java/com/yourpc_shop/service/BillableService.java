package com.yourpc_shop.service;

import java.util.List;
import java.util.Set;

import com.yourpc_shop.entity.Billable;
import com.yourpc_shop.entity.Item;

public interface BillableService
{
    void add(Billable billable) throws Exception;
    void delete(int id);
    void update(Billable billable);
    Billable getOne(int id);
    List<Billable> getAll();
    Set<Billable> getBillableWithItems();
    Billable findByName(String name);
}