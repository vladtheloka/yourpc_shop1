package com.internetshop.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Orders extends AbstractEntity {
	private LocalDateTime date;

	@ManyToOne
	private User user;


	@ManyToMany
	 @JoinTable(name = "Orders_Commodity", joinColumns =
	 @JoinColumn(name = "OrdersID"), inverseJoinColumns
	 = @JoinColumn(name = "ComodityID"))
	 private Set<Commodity> Commodities = new HashSet<>();

	
	 public Orders() {
		// TODO Auto-generated constructor stub
	}
	public Orders(LocalDateTime date) {
		super();
		this.date = date;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Set<Commodity> getCommodities() {
		return Commodities;
	}

	public void setCommodities(Set<Commodity> commodities) {
		Commodities = commodities;
	}

	@Override
	public String toString() {
		return "Orders [date=" + date + "]";
	}
	 

}
