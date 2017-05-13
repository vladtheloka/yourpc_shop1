package com.yourpc.service;

import java.util.List;

import com.yourpc.entity.User;

public interface UserService
{
	void add(User user);
	void delete(int id);
    void update(User user);
	User getOne(int id);
	List<User> getAll();
}
