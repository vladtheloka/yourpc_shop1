package com.yourpc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourpc.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Integer>
{
    User findByName(String name);
    User findByEmail(String email);
    @Query("select u from User u left join fetch u.billable where u.id=:id")
    User userWithBillables(@Param("id") int id);
}
