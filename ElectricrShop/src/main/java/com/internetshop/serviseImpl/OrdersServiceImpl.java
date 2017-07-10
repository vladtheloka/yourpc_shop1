package com.internetshop.serviseImpl;

import com.internetshop.dao.CommodityDao;
import com.internetshop.dao.OrdersDao;
import com.internetshop.dao.UserDao;
import com.internetshop.entity.Commodity;
import com.internetshop.entity.Orders;
import com.internetshop.entity.User;
import com.internetshop.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	private OrdersDao ordersDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private CommodityDao commodityDao;


	public void save(Orders orders) {
		ordersDao.save(orders);
	}

	public List<Orders> findAll() {
		

		return ordersDao.findAll();
	}

	public Orders findOne(int id) {

		return ordersDao.findOne(id);
	}

	public void delete(int id) {
		ordersDao.delete(id);
	}

	public void update(Orders orders) {
		ordersDao.save(orders);
	}

	@Override
	public void addtobacket(Principal principal, int comID) {

		User user = userDao.userWithCommputerCommodities(Integer.parseInt(principal.getName()));

		Commodity commodity = commodityDao.findOne(comID);

		user.getCommodities().add(commodity);

		userDao.save(user);


	}



	@Override
	public void buy(int userID) {
		Orders orders = new Orders(LocalDateTime.now());
		ordersDao.saveAndFlush(orders);
		User user = userDao.findOne(userID);
		orders.setUser(user);


			for (Commodity commodity : user.getCommodities()) {
				orders.getCommodities().add(commodity);
				ordersDao.save(orders);
			}

		userDao.save(user);

	}



}
