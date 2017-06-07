package com.yourpc_shop.editors;

import com.yourpc_shop.entity.User;

import java.beans.PropertyEditorSupport;

public class UserEditor extends PropertyEditorSupport
{
    @Override
    public void setAsText(String id) throws IllegalArgumentException
    {
        User user = new User();
        user.setId(Integer.parseInt(id));
        setValue(user);
    }
}