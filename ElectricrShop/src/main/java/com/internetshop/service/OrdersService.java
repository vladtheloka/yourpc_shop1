package com.internetshop.service;


import java.security.Principal;
import java.util.List;

import com.internetshop.entity.Orders;
//import com.internetshop.entity.User;

public interface OrdersService{
	void save(Orders orders);

	List<Orders> findAll();

	Orders findOne(int id);

	void delete(int id);

	void update(Orders orders);

	void addtobacket(Principal principal, int comID);

	void buy (int userID);


}
