package com.yourpc.service;

import java.util.List;

import com.yourpc.entity.User;

public interface UserService
{
	void add(User user) throws Exception;
	void delete(int id);
    void update(User user) throws Exception;
	User getOne(int id);
	List<User> getAll();
}
