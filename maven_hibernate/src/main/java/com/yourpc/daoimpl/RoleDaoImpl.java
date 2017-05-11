package com.yourpc.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yourpc.dao.RoleDao;
import com.yourpc.entity.Role;
import com.yourpc.entity.User;

@Repository
public class RoleDaoImpl extends GenericDaoImpl<Role, String> implements RoleDao
{	
	public RoleDaoImpl() {
		super(Role.class);
		// TODO Auto-generated constructor stub
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
	
	@Transactional
	public void addUserToRole(User user, Role role)
	{
		user.setRole(role);	
	}
}
