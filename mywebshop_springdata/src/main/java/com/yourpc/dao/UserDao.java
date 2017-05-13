package com.yourpc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourpc.entity.User;

public interface UserDao extends JpaRepository<User, Integer>
{
	User findByName(String name);
	void deleteByName(String name);
}
