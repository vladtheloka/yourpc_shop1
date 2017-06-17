package com.yourpc_shop.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="item")
public class Item extends AbstractEntity
{
    @Column(name="itemName")
    @Getter @Setter
    private String name;

    @Column(name="itemContent")
    @Getter @Setter
    private String content;

    @Column(name="itemPrice")
    @Getter @Setter
    private int price;

    @Column(name = "image")
    @Getter @Setter
    private String pathImage;

    @ManyToOne
    @Getter @Setter
    private Category category;

    @Getter @Setter
    @ManyToMany
    @JoinTable(name = "user_item",
            joinColumns = @JoinColumn(name = "itemId"),
            inverseJoinColumns = @JoinColumn(name = "userId"))
    private Set<User> users = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "item_billable",
            joinColumns = @JoinColumn(name = "itemId"),
            inverseJoinColumns = @JoinColumn(name = "billableId"))
    @Getter @Setter
    private Set<Billable> billable = new HashSet<>();

    public Item() {}

    public Item(String name, String content, int price)
    {
        super();
        this.name = name;
        this.content = content;
        this.price = price;
    }

    public Item(String name, String content, int price, String pathImage) {
        this.name = name;
        this.content = content;
        this.price = price;
        this.pathImage = pathImage;
    }

    @Override
    public String toString()
    {
        return "Name: " + name + ", Content: " + content + ", Price: " + price
                + ", Category: " + category;
    }
}