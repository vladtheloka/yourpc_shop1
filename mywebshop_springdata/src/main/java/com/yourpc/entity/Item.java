package com.yourpc.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item extends AbstractEntity
{	
	@Column(name="itemName")
	private String name;
	
	@Column(name="itemContent")
	private String content;
	
	@Column(name="itemPrice")
	private int price;
	
	@Column(name="itemImage", columnDefinition = "mediumblob")
	private byte[] image;
	
	@ManyToOne()
	private Category category;
	
	@ManyToMany()
	@JoinTable(name = "item_billable", 
	joinColumns = @JoinColumn(name = "itemId"), 
	inverseJoinColumns = @JoinColumn(name = "billableId"))
	private List<Billable> billable = new ArrayList<Billable>();
	
	public Item() {}
	
	public Item(String name, String content, int price, byte[] image)
	{
		super();
		this.name = name;
		this.content = content;
		this.price = price;
		this.image = image;
	}

	public Category getCategory() 
	{
		return category;
	}

	public void setCategory(Category category) 
	{
		this.category = category;
	}

	public List<Billable> getBillable()
	{
		return billable;
	}

	public void setBillable(List<Billable> billable)
	{
		this.billable = billable;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public int getPrice() 
	{
		return price;
	}

	public void setPrice(int price) 
	{
		this.price = price;
	}

	public byte[] getImage() 
	{
		return image;
	}

	public void setImage(byte[] image) 
	{
		this.image = image;
	}

	@Override
	public String toString() 
	{
		return "Item [name=" + name + ", content=" + content + ", price=" + price + ", image=" + Arrays.toString(image)
				+ ", category=" + category + ", billable=" + billable + "]";
	}
}
