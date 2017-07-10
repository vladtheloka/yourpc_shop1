package com.internetshop.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Countries") 
public class Country extends AbstractEntity{
	
	private String name;

	private String pathImage;
	
	@OneToMany (mappedBy = "country")
	private Set<Maker> Makers = new HashSet<>();
	
	public Country() {
		
	}
	public Country(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Maker> getMakers() {
		return Makers;
	}
	public void setMakers(Set<Maker> Makers) {
		this.Makers = Makers;
	}

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

	@Override
	public String toString() {
		return name;
	}
	

}
