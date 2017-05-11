package com.yourpc.dao;

import com.yourpc.entity.User;

public interface UserDao extends GenericDao<User, String>
{
	String validate(String name, String password);
	void delete(String fieldName, String fieldValue);
}
