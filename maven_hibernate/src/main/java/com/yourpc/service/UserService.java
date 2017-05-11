package com.yourpc.service;

import java.util.List;

import com.yourpc.entity.Billable;
import com.yourpc.entity.Role;
import com.yourpc.entity.User;

public interface UserService 
{
	User add(User user);
	void delete(String fieldName, String fieldValue);
    User update(User user);
	User getOne(String fieldName, String fieldValue);
	List<User> getAll();
	String validate(String name, String password);
	void addRoleToUser(User user, Role role);
	void addBillableToUser(User user, Billable billable);
}
