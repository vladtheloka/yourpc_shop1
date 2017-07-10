package com.internetshop.dao;


import com.internetshop.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrdersDao extends JpaRepository<Orders, Integer>  {


}
