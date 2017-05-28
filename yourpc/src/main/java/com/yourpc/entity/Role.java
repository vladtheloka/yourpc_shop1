package com.yourpc.entity;


import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role extends AbstractEntity
{
	@Column(name="roleName")
    @Getter @Setter
	private String name;
	
	@OneToMany(mappedBy = "role")
    @Getter @Setter
	private Set<User> user = new HashSet<>();
	
	public Role(){}
	
	public Role(String name) 
	{
		super();
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
