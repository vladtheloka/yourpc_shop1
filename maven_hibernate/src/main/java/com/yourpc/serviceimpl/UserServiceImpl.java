package com.yourpc.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yourpc.dao.GenericDao;
import com.yourpc.dao.UserDao;
import com.yourpc.entity.Role;
import com.yourpc.entity.User;
import com.yourpc.service.UserService;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, String> implements UserService
{
	private UserDao userDao;
	
	@Autowired
	public UserServiceImpl(
			@Qualifier("userDaoImpl")GenericDao<User, String> genericDao) 
	{
		super(genericDao);
		this.userDao = (UserDao) genericDao;
	}

	@Override
	public String validate(String name, String password) 
	{
		return userDao.validate(name, password);
	}

	@Override
	public void addRoleToUser(User user, Role role) 
	{
		userDao.addRoleToUser(user, role);
	}

	@Override
	public void removeRoleFromUser(User user)
	{
		userDao.removeRoleFromUser(user);	
	}
}