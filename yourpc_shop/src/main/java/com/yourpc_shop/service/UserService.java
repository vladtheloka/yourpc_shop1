package com.yourpc_shop.service;

import java.util.List;

import com.yourpc_shop.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService
{
    void add(User user) throws Exception;
    void delete(int id);
    void update(User user);
    User getOne(int id);
    List<User> getAll();
    User userWithBillables(int id);
    User userWithItems(int id);
    User findByUuid(String uuid);
    Page<User> findAllPages(Pageable pageable);
}