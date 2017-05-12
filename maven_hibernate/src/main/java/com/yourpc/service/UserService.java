package com.yourpc.service;

import com.yourpc.entity.Role;
import com.yourpc.entity.User;

public interface UserService extends GenericService<User, String>
{
	String validate(String name, String password);
	void addRoleToUser(User user, Role role);
	void removeRoleFromUser(User user);
}
