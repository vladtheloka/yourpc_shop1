package com.yourpc_shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yourpc_shop.entity.Billable;

import java.time.LocalDateTime;
import java.util.Set;

public interface BillableDao extends JpaRepository<Billable, Integer>
{
    @Query("select distinct b from Billable b left join fetch b.item")
    Set<Billable> getBillableWithItems();
}
