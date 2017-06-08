package com.yourpc_shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourpc_shop.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Integer>
{
    User findByName(String name);
    User findByEmail(String email);
    @Query("select u from User u left join fetch u.billable where u.id=:id")
    User userWithBillables(@Param("id") int id);

    @Query("select u from User u left join fetch u.items where u.id=:id")
    User userWithItems(@Param("id") int id);
}