package com.yourpc.daoimpl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yourpc.dao.BillableDao;
import com.yourpc.entity.Billable;
import com.yourpc.entity.Item;
import com.yourpc.entity.User;

@Repository
public class BillableDaoImpl extends GenericDaoImpl<Billable, String> implements BillableDao 
{
	public BillableDaoImpl() 
	{
		super(Billable.class);
	}

	@Transactional
	@Override
	public void addUserToBillable(User user, Billable billable) 
	{
		billable.setUser(user);
		getEntityManager().merge(billable);
	}

	@Transactional
	@Override
	public void addBillableToItem(Item item, Billable billable)
	{
		billable.getItem().add(item);
		getEntityManager().merge(billable);
	}
}
