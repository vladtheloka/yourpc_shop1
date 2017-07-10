package com.internetshop.validator.UserValidator;

import com.internetshop.dao.UserDao;
import com.internetshop.entity.User;
import com.internetshop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserValidator implements Validator {
    @Autowired
    private UserDao userDao;
    

    @Override
    public void validate(Object o) throws Exception {
        User user = (User) o;
        if(user.getName().isEmpty()){
            throw  new UserExeption(UserValidationMessages.EMPTY_USERNAME_FIELD);
        }else if (userDao.findByName(user.getName()) != null){
            throw  new UserExeption(UserValidationMessages.USERNAME_ALREADY_EXIST);
        }else if(user.getEmail().isEmpty()){
        	throw new UserExeption(UserValidationMessages.EMPTY_EMAIL);
        }else if (!user.getEmail().contains("@")){
        	throw new UserExeption(UserValidationMessages.WRONG_EMAIL);
        }else if (userDao.findByEmail(user.getEmail()) != null){
        	throw new UserExeption(UserValidationMessages.EMAIL_ALREADY_EXIST);
        }else if (user.getPassword().isEmpty()){
        	throw new UserExeption(UserValidationMessages.EMPTY_PASSWORD);
        }else if (user.getPassword().length() < 5){
        	throw new UserExeption(UserValidationMessages.TO_SHORT_PASSWORD);
        }

    }



}
