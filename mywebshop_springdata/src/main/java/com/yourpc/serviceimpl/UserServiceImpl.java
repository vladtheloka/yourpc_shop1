package com.yourpc.serviceimpl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourpc.dao.UserDao;
import com.yourpc.entity.Role;
import com.yourpc.entity.User;
import com.yourpc.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDao userDao;

	public void add(User user) 
	{
		//user validation/crypt
		userDao.save(user);	
	}

	public void delete(int id) 
	{
		userDao.delete(id);	
	}

	public void update(User user) 
	{
		userDao.save(user);	
	}

	public User getOne(int id) 
	{
		return userDao.findOne(id);
	}

	public List<User> getAll() 
	{
		return userDao.findAll();
	}

	public String validate(String name, String password) 
	{
		String flag = "Failure";
		User user = null;

		try
		{
			user = userDao.findByNameAndPassword(name, password);
	
			if(name.equalsIgnoreCase(user.getName()) && password.equals(user.getPassword()))
			{
				flag = "Success";
			}
		}
		
		catch(NoResultException e)
		{
			System.out.println(e.getMessage());
		}
		catch(NonUniqueResultException e)
		{
			System.out.println(e.getMessage());
		}
		
		return flag;
	}

	public void addRoleToUser(User user, Role role) 
	{
		user.setRole(role);
		userDao.save(user);
	}

	public void removeRoleFromUser(User user) 
	{
		user.setRole(null);
		userDao.save(user);
	}
}