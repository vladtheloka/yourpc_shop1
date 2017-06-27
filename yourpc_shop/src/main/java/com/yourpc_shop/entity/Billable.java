package com.yourpc_shop.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="billable")
public class Billable extends AbstractEntity
{
    @Column(name="billableTime")
    @Getter @Setter
    private LocalDateTime localDateTime;

    @Getter @Setter
    private int price;

    @ManyToOne
    @Getter @Setter
    private User user;

    @ManyToMany
    @JoinTable(name = "item_billable",
            joinColumns = @JoinColumn(name = "billableId"),
            inverseJoinColumns = @JoinColumn(name = "itemId"))
    @Getter @Setter
    private Set<Item> item = new HashSet<>();

    public Billable() {}

    public Billable(LocalDateTime localDateTime)
    {
        super();
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString()
    {
        return "Time: " + localDateTime + ", User: " + user + ", Item" + item;
    }

}