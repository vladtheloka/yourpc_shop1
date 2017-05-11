package com.yourpc.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yourpc.dao.RoleDao;
import com.yourpc.entity.Role;
import com.yourpc.entity.User;

@Repository
public class RoleDaoImpl extends GenericDaoImpl<Role, String> implements RoleDao
{	
	public RoleDaoImpl() 
	{
		super(Role.class);
	}

	@Override
	public void delete(String fieldName, String fieldValue)
	{
		Role role = super.getOne(fieldName, fieldValue);
		List<User> users = role.getUser();
		for (User user : users) 
		{
			user.setRole(null);
			getEntityManager().merge(user);
		}
		super.delete(fieldName, fieldValue);
	}
}
