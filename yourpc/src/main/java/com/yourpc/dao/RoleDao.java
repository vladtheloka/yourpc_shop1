package com.yourpc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourpc.entity.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleDao extends JpaRepository<Role, Integer>
{
	@Query("select r from Role r left join fetch r.user where r.id=:id")
	Role roleWithUser(@Param("id") int id);
}
