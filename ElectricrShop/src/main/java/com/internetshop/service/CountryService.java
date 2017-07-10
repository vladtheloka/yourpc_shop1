package com.internetshop.service;

import java.util.List;

import com.internetshop.entity.Country;
import org.springframework.web.multipart.MultipartFile;
//import com.internetshop.entity.Maker;
//import com.internetshop.entity.Orders;

public interface CountryService   {
	
	void save(Country country, MultipartFile countryImage) throws Exception;

	List<Country> findAll();

	Country findOne(int id);

	void delete(int id);

	void update(Country country);
	
//	void addMakerToCountry (Country country, Maker Maker);
	

}
