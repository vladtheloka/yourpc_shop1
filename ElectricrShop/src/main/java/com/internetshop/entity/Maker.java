package com.internetshop.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Maker extends AbstractEntity {
	
	private String name;
	
	@ManyToOne
	private Country country;
	
	@OneToMany (mappedBy = "maker")
	private Set<Commodity> commodities = new HashSet<>();

	public Maker() {
		// TODO Auto-generated constructor stub
	}
	public Maker(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}

	public Set<Commodity> getCommodities() {
		return commodities;
	}

	public void setCommodities(Set<Commodity> commodities) {
		commodities = commodities;
	}

	@Override
	public String toString() {
		return name;
	}

	

}
