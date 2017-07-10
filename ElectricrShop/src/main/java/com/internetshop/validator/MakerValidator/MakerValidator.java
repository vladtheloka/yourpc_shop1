package com.internetshop.validator.MakerValidator;

import com.internetshop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.internetshop.dao.MakerDao;
import com.internetshop.entity.Maker;

@Component
public class MakerValidator implements Validator {
	
	@Autowired
	private MakerDao makerDao;

	@Override
	public void validate(Object o) throws Exception {
		
		Maker maker = (Maker) o;
		if(maker.getName().isEmpty()){
			throw new MakerException(MakerValidationMessages.EMPTY_MAKER_NAME);
		}else if (makerDao.findByName(maker.getName()) != null){
			throw new MakerException(MakerValidationMessages.MAKER_NAME_ALREADY_EXIST);
		}
		
	}

}
