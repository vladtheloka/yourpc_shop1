package com.internetshop.service;
import com.internetshop.entity.Maker;
import java.util.List;


public interface MakerService  {
	void save(Maker maker)  throws Exception;
	List<Maker> findAll();
	Maker findOne(int id);
	void delete(int id);
	void update(Maker maker);
	
	


}
