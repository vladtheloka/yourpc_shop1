package com.internetshop.validator.UserValidator;

/**
 * Created by admin on 29.05.2017.
 */
public interface UserValidationMessages {

    String EMPTY_USERNAME_FIELD = "EMPTY USERNAME FIELD";
    String USERNAME_ALREADY_EXIST = "USERNAME ALREADY EXIST";
    
    String EMPTY_PASSWORD = "EMPTY PASSWORD"; 
    String TO_SHORT_PASSWORD = "TO SHORT PASSWORD";
    
    
    String EMPTY_EMAIL = "EMPTY EMAIL";
    String WRONG_EMAIL = "EMAIL MUST CONTAINS @";
    String EMAIL_ALREADY_EXIST = "EMAIL ALREADY EXIST";
    
    
}
