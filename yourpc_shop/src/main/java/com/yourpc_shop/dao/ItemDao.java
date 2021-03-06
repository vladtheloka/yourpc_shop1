package com.yourpc_shop.dao;

import com.yourpc_shop.entity.Billable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yourpc_shop.entity.Item;

import java.util.List;
import java.util.Set;

public interface ItemDao extends JpaRepository<Item, Integer>
{
    Item findByName(String name);
    @Query("select distinct i from Item i left join fetch i.billable where i.id =:id")
    Item getItemWithBillables(@Param("id")int id);

    @Query("select distinct i from Item i left join fetch i.billable")
    Set<Billable> getItemWithBillables();

    @Query("select i from Item i left join fetch i.users where i.id =:id")
    Item itemWithUsers(@Param("id") int id);

    @Query("select i from Item i where i.name like %:search%")
    List<Item> searchItems(@Param("search") String search);

    @Query("select i from Item i where i.price between :min and :max")
    List<Item> searchByPrice(@Param("min") int min, @Param("max") int max);
}