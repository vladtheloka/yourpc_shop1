package com.internetshop.editors;

import com.internetshop.entity.Maker;

import java.beans.PropertyEditorSupport;

/**
 * Created by admin on 28.05.2017.
 */

public class MakerEditor extends PropertyEditorSupport {


    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Maker maker = new Maker();
        maker.setId(Integer.parseInt(text));
        setValue(maker);
    }






}
