package com.yourpc.dao;

import com.yourpc.entity.Role;
import com.yourpc.entity.User;

public interface UserDao extends GenericDao<User, String>
{
	String validate(String name, String password);
	void addRoleToUser(User user, Role role);
	void removeRoleFromUser(User user);
}
