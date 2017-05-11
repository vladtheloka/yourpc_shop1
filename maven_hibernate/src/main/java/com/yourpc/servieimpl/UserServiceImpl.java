package com.yourpc.servieimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yourpc.dao.UserDao;
import com.yourpc.entity.Billable;
import com.yourpc.entity.Role;
import com.yourpc.entity.User;
import com.yourpc.service.UserService;

@Service()
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDao userDao;
	
	@Transactional
	public User add(User user) 
	{
		return userDao.add(user);
	}

	public void delete(String fieldName, String fieldValue)
	{
		userDao.delete(fieldName, fieldValue);	
	}

	public User update(User user) 
	{
		return userDao.update(user);
	}

	public User getOne(String fieldName, String fieldValue)
	{
		return userDao.getOne(fieldName, fieldValue);
	}

	public List<User> getAll() 
	{
		return userDao.getAll();
	}

	public String validate(String name, String password) 
	{
		return userDao.validate(name, password);
	}

	public void addRoleToUser(User user, Role role) 
	{
		user.setRole(role);	
	}

	public void addBillableToUser(User user, Billable billable) 
	{
		billable.setUser(user);
	}
}
