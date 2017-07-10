package com.internetshop.validator.CommodityValidator;

import com.internetshop.entity.Commodity;
import com.internetshop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.internetshop.dao.CommodityDao;

@Component
public class CommodityValidator implements Validator {
	@Autowired
	private CommodityDao comComodityDao;
	

	@Override
	public void validate(Object o) throws Exception {
	Commodity commodity = (Commodity) o;
	
	if(commodity.getPrice() <=0){
		throw new CommodityException(CommodityValidationMessages.PRICE_MUST_BE_BIGGER_THAN_0);
	}else if(commodity.getModel().isEmpty()){
		throw new CommodityException(CommodityValidationMessages.EMPTY_MODEL_FIELD);
	}else if(comComodityDao.findByModel(commodity.getModel()) !=null){
		throw new CommodityException(CommodityValidationMessages.MODEL_ALREADY_EXIST);
	}else if(commodity.getNumber() <=0){
		throw new CommodityException(CommodityValidationMessages.NUMBER_OF_COMMODITY_MUST_BE_BIGGER_THAN_0);
	}
		
	}
	
	

}
