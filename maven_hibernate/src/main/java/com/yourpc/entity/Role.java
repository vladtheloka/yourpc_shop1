package com.yourpc.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role extends AbstractEntity
{
	@Column(name="roleName")
	private String name;
	
	@OneToMany(mappedBy = "role")
	private List<User> user = new ArrayList<User>();
	
	public Role(){}
	
	public Role(String name) 
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

	public List<User> getUser() 
	{
		return user;
	}

	public void setUser(List<User> user) 
	{
		this.user = user;
	}

	@Override
	public String toString() 
	{
		return "Role [name=" + name + "]";
	}
}
