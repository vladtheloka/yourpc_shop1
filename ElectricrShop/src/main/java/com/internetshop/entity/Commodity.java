package com.internetshop.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Commodity extends AbstractEntity {
	private int price;
	private String model;
	private int number;
	private String computerPathImage;
	
	@ManyToMany
	 @JoinTable(name = "Orders_Commodity", joinColumns =
	 @JoinColumn(name = "ComodityID"), inverseJoinColumns
	 = @JoinColumn(name = "OrdersID"))
	 private Set<Orders> orders = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "User_Commodity", joinColumns =
	@JoinColumn(name = "CommodityID"), inverseJoinColumns
			= @JoinColumn(name = "UserID"))
	private Set<User> users = new HashSet<>();
	
	@ManyToOne
	private Maker maker;

	@ManyToOne
	private Categories categories;
	
	public Commodity(int price, String model, int number) {
		super();
		this.price = price;
		this.model = model;
		this.number = number;
	}

	
	public Commodity() {
		// TODO Auto-generated constructor stub
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}



	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}



	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public Maker getMaker() {
		return maker;
	}


	public void setMaker(Maker Maker) {
		this.maker = Maker;
	}


	public Set<Orders> getOrders() {
		return orders;
	}


	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String getComputerPathImage() {
		return computerPathImage;
	}

	public void setComputerPathImage(String computerPathImage) {
		this.computerPathImage = computerPathImage;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}


	@Override
	public String toString() {
		return "Commodity{" +
				"price=" + price +
				", model='" + model + '\'' +
				", number=" + number +
				", computerPathImage='" + computerPathImage + '\'' +
				", maker=" + maker +
				", categories=" + categories +
				'}';
	}
}
