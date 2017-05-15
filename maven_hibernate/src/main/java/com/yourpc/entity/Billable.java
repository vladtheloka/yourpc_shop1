package com.yourpc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="billable")
public class Billable extends AbstractEntity
{	
	@Column(name="billableName")
	private String name;
	
	@Column(name="billableAddress")
	private String address;
	
	@ManyToOne()
	private User user;
	
	@ManyToMany
	@JoinTable(name = "item_billable", 
	joinColumns = @JoinColumn(name = "billableId"), 
	inverseJoinColumns = @JoinColumn(name = "itemId"))
	private List<Item> item = new ArrayList<Item>();
	
	public Billable() {}
	
	public Billable(String name, String address) 
	{
		super();
		this.name = name;
		this.address = address;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public User getUser() 
	{
		return user;
	}

	public void setUser(User user) 
	{
		this.user = user;
	}

	public List<Item> getItem() 
	{
		return item;
	}

	public void setItem(List<Item> item) 
	{
		this.item = item;
	}

	@Override
	public String toString() 
	{
		return "Name: " + name + ", Address: " + address + ", User: " + user + ", Item: " + item;
	}
}
