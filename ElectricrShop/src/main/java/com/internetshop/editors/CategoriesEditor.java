package com.internetshop.editors;

import com.internetshop.entity.Categories;
import com.internetshop.entity.Commodity;

import java.beans.PropertyEditorSupport;

/**
 * Created by admin on 06.07.2017.
 */
public class CategoriesEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Categories categories = new Categories();
        categories.setId(Integer.parseInt(text));
        setValue(categories);
    }
}
