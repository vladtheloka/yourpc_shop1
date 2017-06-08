package com.yourpc_shop.service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.yourpc_shop.entity.Billable;
import com.yourpc_shop.entity.Item;

public interface BillableService
{
    void add(Billable billable);
    void delete(int id);
    void update(Billable billable);
    Billable getOne(int id);
    List<Billable> getAll();
    Set<Billable> getBillableWithItems();
    void addToCart(Principal principal, int id);
    void deleteFromCart(int userId, int itemId);
    void buy(int userId);
}