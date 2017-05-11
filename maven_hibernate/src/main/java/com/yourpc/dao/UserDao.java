package com.yourpc.dao;

import com.yourpc.entity.Billable;
import com.yourpc.entity.Role;
import com.yourpc.entity.User;

public interface UserDao extends GenericDao<User, String>
{
	String validate(String name, String password);
	void delete(String fieldName, String fieldValue);
	void addRoleToUser(User user, Role role);
	void addBillableToUser(User user, Billable billable);
}
