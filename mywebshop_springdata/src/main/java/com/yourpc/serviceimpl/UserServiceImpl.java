package com.yourpc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourpc.dao.UserDao;
import com.yourpc.entity.User;
import com.yourpc.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDao userDao;

	@Override
	public void add(User user) 
	{
		//user validation/crypt
		userDao.save(user);	
	}

	@Override
	public void delete(int id) 
	{
		userDao.delete(id);	
	}

	@Override
	public void update(User user) 
	{
		userDao.save(user);	
	}

	@Override
	public User getOne(int id) 
	{
		return userDao.findOne(id);
	}

	@Override
	public List<User> getAll() 
	{
		return userDao.findAll();
	}

}