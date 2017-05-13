package com.yourpc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourpc.dao.RoleDao;
import com.yourpc.entity.Role;
import com.yourpc.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService 
{
	@Autowired
	private RoleDao roleDao;

	@Override
	public void add(Role role) 
	{
		roleDao.save(role);	
	}

	@Override
	public void delete(int id) 
	{
		roleDao.delete(id);	
	}

	@Override
	public void update(Role role) 
	{
		roleDao.save(role);	
	}

	@Override
	public Role getOne(int id)
	{
		return roleDao.findOne(id);
	}

	@Override
	public List<Role> getAll() 
	{
		return roleDao.findAll();
	}

}
