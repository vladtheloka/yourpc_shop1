package com.yourpc.dao;

import com.yourpc.entity.Role;
import com.yourpc.entity.User;

public interface RoleDao extends GenericDao<Role, String>
{
	void addUserToRole(User user, Role role);
}
