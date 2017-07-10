package com.internetshop.validator.CountryValidator;

import com.internetshop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.internetshop.dao.CountryDao;
import com.internetshop.entity.Country;
@Component
public class CountryValidator implements Validator {
	
	@Autowired
	private CountryDao countryDao;

	@Override
	public void validate(Object o) throws Exception {
	Country country = (Country) o;
	
	
	if(country.getName().isEmpty()){
		throw new CountryException(CountryValidatorMessages.FILD_NAME_IS_EMPTY);
	}else if(countryDao.findByName(country.getName())!=null){
		throw new CountryException(CountryValidatorMessages.COUNTRY_ALREADY_EXIST);
	}
		
	}

}
