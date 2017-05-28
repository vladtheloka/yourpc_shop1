package com.yourpc.entity;

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
	
	@Column(name="itemImage", columnDefinition = "mediumblob")
    @Getter @Setter
	private byte[] image;

    @ManyToOne
    @Getter @Setter
	private Category category;
	
	@ManyToMany
	@JoinTable(name = "item_billable", 
	joinColumns = @JoinColumn(name = "itemId"), 
	inverseJoinColumns = @JoinColumn(name = "billableId"))
    @Getter @Setter
	private Set<Billable> billable = new HashSet<>();
	private String address;
	private String user;
	private String item;

	public Item() {}
	
	public Item(String name, String content, int price, byte[] image)
	{
		super();
		this.name = name;
		this.content = content;
		this.price = price;
		this.image = image;
	}

	@Override
	public String toString() 
	{
		return "Name: " + name + ", Content: " + content + ", Price: " + price 
				+ ", Category: " + category;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUser() {
		return user;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItem() {
		return item;
	}
}
