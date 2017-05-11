package com.yourpc.daoimpl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yourpc.dao.BillableDao;
import com.yourpc.entity.Billable;
import com.yourpc.entity.Item;
import com.yourpc.entity.User;

@Repository
public class BillableDaoImpl extends GenericDaoImpl<Billable, Integer> implements BillableDao 
{
	public BillableDaoImpl() {
		super(Billable.class);
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public void addUserToBillable(User user, Billable billable) 
	{
		billable.setUser(user);
	}

	@Transactional
	public void addBillableToItem(Item item, Billable billable)
	{
		billable.getItem().add(item);
		getEntityManager().merge(billable);
	}
}
