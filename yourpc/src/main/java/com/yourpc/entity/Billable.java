package com.yourpc.entity;


import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="billable")
public class Billable extends AbstractEntity
{	
	@Column(name="billableName")
    @Getter @Setter
	private String name;

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
	
	public Billable(String name)
	{
		super();
		this.name = name;
	}

	@Override
	public String toString() 
	{
		return "Name: " + name + ", User: " + user + ", Item" + item;
	}
}
