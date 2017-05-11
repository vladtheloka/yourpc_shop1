package com.yourpc.entity;

import java.util.ArrayList;
import java.util.List;

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
	private String name;
	
	@Column(name="userEmail")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="userAddress")
	private String address;
	
	@ManyToOne()
	private Role role;
		
	@OneToMany(mappedBy = "user")
	private List<Billable> billable = new ArrayList<Billable>();
	
	public User() {}

	public User(String name, String email, String password, String address) 
	{
		super();
		this.name = name;
		this.email = email;
		this.password = password;
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

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public Role getRole() 
	{
		return role;
	}

	public void setRole(Role role)
	{
		this.role = role;
	}

	public List<Billable> getBillable() 
	{
		return billable;
	}

	public void setBillable(List<Billable> billable)
	{
		this.billable = billable;
	}

	@Override
	public String toString() 
	{
		return "User [name=" + name + ", email=" + email + ", password=" + password + ", address=" + address + ", role="
				+ role + "]";
	}
}
