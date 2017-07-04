package com.yourpc_shop.dao;

import com.yourpc_shop.entity.Billable;
import com.yourpc_shop.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    @Query(value = "select i from Item i where i.category.name='CPU'",
            countQuery = "select count(i) from Item i where i.category.name='CPU'")
    Page<Item> allCpu(Pageable pageable);

    @Query(value = "select i from Item i where i.category.name='GPU'",
            countQuery = "select count(i) from Item i where i.category.name='GPU'")
    Page<Item> allGpu(Pageable pageable);

    @Query(value = "select i from Item i where i.category.name='RAM'",
            countQuery = "select count(i) from Item i where i.category.name='RAM'")
    Page<Item> allRam(Pageable pageable);

    @Query(value = "select i from Item i where i.category.name='PSU'",
            countQuery = "select count(i) from Item i where i.category.name='PSU'")
    Page<Item> allPsu(Pageable pageable);

    @Query(value = "select i from Item i where i.category.name='Case'",
            countQuery = "select count(i) from Item i where i.category.name='Case'")
    Page<Item> allCase(Pageable pageable);

    @Query(value = "select i from Item i where i.category.name='Storage'",
            countQuery = "select count(i) from Item i where i.category.name='Storage'")
    Page<Item> allStorage(Pageable pageable);

    @Query(value = "select i from Item i where i.category.name='Motherboard'",
            countQuery = "select count(i) from Item i where i.category.name='Motherboard'")
    Page<Item> allMotherboard(Pageable pageable);

    @Query("select i from Item i where i.name like %:search%")
    List<Item> searchItems(@Param("search") String search);



}