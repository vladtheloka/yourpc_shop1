package com.yourpc.dao;

import com.yourpc.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yourpc.entity.Billable;

import java.util.Set;

public interface BillableDao extends JpaRepository<Billable, Integer>
{
	Billable findByName(String name);
	@Query("select distinct b from Billable b left join fetch b.item")
	Set<Billable> getBillableWithItems();
}
