package com.yourpc_shop.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category extends AbstractEntity
{
    @Column(name="categoryName")
    @Getter @Setter
    private String name;

    @OneToMany(mappedBy = "category")
    @Getter @Setter
    private Set<Item> item = new HashSet<>();

    public Category() {}

    public Category(String name)
    {
        super();
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }
}