package com.yourpc_shop.editors;

import com.yourpc_shop.entity.Category;

import java.beans.PropertyEditorSupport;

public class CategoryEditor extends PropertyEditorSupport
{
    @Override
    public void setAsText(String id) throws IllegalArgumentException
    {
        Category category = new Category();
        category.setId(Integer.parseInt(id));
        setValue(category);
    }
}
