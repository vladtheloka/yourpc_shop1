package com.internetshop.dao;

import com.internetshop.entity.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
//import com.internetshop.entity.Maker;

public interface CommodityDao extends JpaRepository<Commodity, Integer>{
	Commodity findByModel (String model);

    @Query("select c from Commodity c left join fetch c.users where c.id=:id")
    Commodity comCommodityWithUser(@Param("id") int id);

    @Query("select c from Commodity c where c.maker.name like %:search%")
    List<Commodity> commodityByMaker (@Param("search") String search);


}
