package com.yourpc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category extends AbstractEntity
{
	@Column(name="categoryName")
	private String name;
	
	@OneToMany(mappedBy = "category")
	private List<Item> item = new ArrayList<Item>();
	
	public Category() {}
	
	public Category(String name) 
	{
		super();
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
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
		return name;
	}
}
