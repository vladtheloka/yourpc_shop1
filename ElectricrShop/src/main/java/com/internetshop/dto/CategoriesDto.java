package com.internetshop.dto;

/**
 * Created by admin on 07.07.2017.
 */
public class CategoriesDto {
    private int id;
    private String name;

    public CategoriesDto() {
    }

    public CategoriesDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CategoriesDto{" +
                "id=" + id +
                ", category='" + name + '\'' +
                '}';
    }
}
