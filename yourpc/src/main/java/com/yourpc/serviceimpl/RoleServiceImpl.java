package com.yourpc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourpc.dao.RoleDao;
import com.yourpc.dao.UserDao;
import com.yourpc.entity.Role;
import com.yourpc.entity.User;
import com.yourpc.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService 
{
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private UserDao userDao;

	public void add(Role role) 
	{
		roleDao.save(role);	
	}

	public void delete(int id) 
	{
		Role role = roleDao.findOne(id);
		
		List<User> users = role.getUser();
		for (User u : users) 
		{
			u.setRole(null);
			userDao.save(u);
		}
		roleDao.delete(id);	
	}

	public void update(Role role) 
	{
		roleDao.save(role);	
	}

	public Role getOne(int id)
	{
		return roleDao.findOne(id);
	}

	public List<Role> getAll() 
	{
		return roleDao.findAll();
	}

	public Role findByName(String name) 
	{
		return roleDao.findByName(name);
	}

	public void deleteByName(String name) 
	{
		Role role = roleDao.findByName(name);
		
		List<User> users = role.getUser();
		for (User u : users) 
		{
			u.setRole(null);
			userDao.save(u);
		}
		roleDao.deleteByName(name);	
	}

}
