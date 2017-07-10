package com.internetshop.editors;

import com.internetshop.entity.Country;

import java.beans.PropertyEditorSupport;

/**
 * Created by admin on 30.05.2017.
 */
public class CountryEditor extends PropertyEditorSupport {


    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Country country = new Country();
        country.setId(Integer.parseInt(text));
        setValue(country);
    }
}
