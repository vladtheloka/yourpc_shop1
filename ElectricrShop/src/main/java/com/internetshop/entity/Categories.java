package com.internetshop.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 05.07.2017.
 */
@Entity
public class Categories extends AbstractEntity {
    private String name;



    @OneToMany (mappedBy = "categories")
    private Set<Commodity> commodities = new HashSet<>();


    public Categories() {
    }

    public Categories(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Commodity> getCommodities() {
        return commodities;
    }

    public void setCommodities(Set<Commodity> commodities) {
        this.commodities = commodities;
    }

    @Override
    public String toString() {
        return name;
    }
}
