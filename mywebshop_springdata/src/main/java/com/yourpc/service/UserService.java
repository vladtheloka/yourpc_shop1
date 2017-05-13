package com.yourpc.service;

import java.util.List;

import com.yourpc.entity.Role;
import com.yourpc.entity.User;

public interface UserService
{
	void add(User user);
	void delete(int id);
    void update(User user);
	User getOne(int id);
	List<User> getAll();
	String validate(String name, String password);
	void addRoleToUser(User user, Role role);
	void removeRoleFromUser(User user);
}
