package com.yourpc.editors;

import com.yourpc.entity.Role;

import java.beans.PropertyEditorSupport;

public class RoleEditor extends PropertyEditorSupport
{
    @Override
    public void setAsText(String id) throws IllegalArgumentException
    {
        Role role = new Role();
        role.setId(Integer.parseInt(id));
        setValue(role);
    }
}
