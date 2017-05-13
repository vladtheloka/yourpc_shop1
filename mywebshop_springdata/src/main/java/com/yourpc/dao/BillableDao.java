package com.yourpc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yourpc.entity.Billable;

public interface BillableDao extends JpaRepository<Billable, Integer>
{
	Billable findByName(String name);
	void deleteByName(String name);
	@Query("select b from Billable b left join fetch b.item where b.name =:name")
	Billable getBillablewithItems(@Param("name")String billableName);
}
