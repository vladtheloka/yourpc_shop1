package com.internetshop.service;

import java.util.List;

//import com.internetshop.entity.Orders;
import com.internetshop.entity.User;
import org.springframework.data.repository.query.Param;

public interface UserService {
	void save(User user) throws Exception;

	List<User> findAll();

	User findOne(int id);

	void delete(int id);

	void update(User user) throws Exception;

	User findByUuid(String uuid);

	void updateConf(User user);

	User userWithCommodyties (int id);

}
