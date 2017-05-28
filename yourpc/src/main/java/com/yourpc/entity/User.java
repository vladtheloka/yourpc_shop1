package com.yourpc.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User extends AbstractEntity
{
	@Column(name="userName")
	@Getter @Setter
	private String name;
	
	@Column(name="userEmail")
    @Getter @Setter
	private String email;
	
	@Column(name="password")
    @Getter @Setter
	private String password;
	
	@Column(name="userAddress")
    @Getter @Setter
	private String address;
	
	@ManyToOne
    @Getter @Setter
	private Role role;
		
	@OneToMany(mappedBy = "user")
    @Getter @Setter
	private Set<Billable> billable = new HashSet<>();
	
	public User() {}

	public User(String name, String email, String password, String address)
	{
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
	}

	@Override
	public String toString()
	{
		return "Name: " + name + ", Email: " + email + ", Password: " + password +
				", Address: " + address + ", Role: " + role;
	}
}
