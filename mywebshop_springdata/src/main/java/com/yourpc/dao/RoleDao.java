package com.yourpc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourpc.entity.Role;

public interface RoleDao extends JpaRepository<Role, Integer>
{
	Role findByName(String name);
	void deleteByName(String name);
}
