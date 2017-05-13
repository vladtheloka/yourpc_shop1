package com.yourpc.service;

import java.util.List;

import com.yourpc.entity.Role;

public interface RoleService
{

	void add(Role role);
	void delete(int id);
    void update(Role role);
	Role getOne(int id);
	List<Role> getAll();
}
