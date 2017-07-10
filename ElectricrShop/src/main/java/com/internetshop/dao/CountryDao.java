package com.internetshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.internetshop.entity.Country;



public interface CountryDao extends JpaRepository<Country, Integer> {
	Country findByName(String name);
	
    @Query("select c from Country c left join fetch c.Makers where c.id=:id")
    Country countryWithMakers(@Param("id") int id);
	

}
