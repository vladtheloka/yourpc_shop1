package com.internetshop.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.internetshop.entity.Maker;

public interface MakerDao extends JpaRepository<Maker, Integer>{
		Maker findByName(String name);
	 @Query("select c from Maker c left join fetch c.commodities where c.id=:id")
	    Maker makerWithComCommodity(@Param("id") int id);



}
