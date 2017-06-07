package com.yourpc_shop.editors;

import com.yourpc_shop.entity.Item;

import java.beans.PropertyEditorSupport;

public class ItemEditor extends PropertyEditorSupport
{
    @Override
    public void setAsText(String id) throws IllegalArgumentException
    {
        Item item = new Item();
        item.setId(Integer.parseInt(id));
        setValue(item);
    }
}
