package com.yourpc.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yourpc.dao.GenericDao;
import com.yourpc.dao.RoleDao;
import com.yourpc.entity.Role;
import com.yourpc.service.RoleService;

@Service
public class RoleServiceImpl extends GenericServiceImpl<Role, String> implements RoleService 
{
	private RoleDao roleDao;

	@Autowired
	public RoleServiceImpl(
			@Qualifier("roleDaoImpl")GenericDao<Role, String> genericDao)
	{
		super(genericDao);
		this.roleDao = (RoleDao) genericDao;
	}
}
