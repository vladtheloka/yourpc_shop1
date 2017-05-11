package com.yourpc.daoimpl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yourpc.dao.UserDao;
import com.yourpc.entity.Billable;
import com.yourpc.entity.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, String> implements UserDao
{
	public UserDaoImpl() 
	{
		super(User.class);
	}

	@Transactional
	public String validate(String name, String password) 
	{
		String flag = "Failure";
		User user = null;

		try
		{
			user = (User) getEntityManager()
				.createQuery("select u from User u where u.name = :value1 and u.password = :value2")
				.setParameter("value1", name)
				.setParameter("value2", password)
				.getSingleResult();
	
			if(name.equalsIgnoreCase(user.getName()) && password.equals(user.getPassword()))
			{
				flag = "Success";
			}
		}
		
		catch(NoResultException e)
		{
			System.out.println(e.getMessage());
		}
		catch(NonUniqueResultException e)
		{
			System.out.println(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public void delete(String fieldName, String fieldValue) 
	{
		User user = super.getOne(fieldName, fieldValue);
		List<Billable> billables = user.getBillable();
		for (Billable billable : billables) 
		{
			billable.setUser(null);
			getEntityManager().merge(billable);
		}
		super.delete(fieldName, fieldValue);
	}
}
