package com.internetshop.dto;

import com.internetshop.entity.Categories;
import com.internetshop.entity.Maker;

/**
 * Created by admin on 08.07.2017.
 */
//
public class CommodityDto {
    private int id;
    private Maker maker;
    private String image;
    private Categories categories;
    private String Model;
    private int price;

    public CommodityDto() {
    }

    public CommodityDto(int id, Maker maker, String image, Categories categories, String model, int price) {
        this.id = id;
        this.maker = maker;
        this.image = image;
        this.categories = categories;
        Model = model;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Maker getMaker() {
        return maker;
    }

    public void setMaker(Maker maker) {
        this.maker = maker;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
