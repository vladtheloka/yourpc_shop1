package com.yourpc.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yourpc.dao.BillableDao;
import com.yourpc.dao.GenericDao;
import com.yourpc.entity.Billable;
import com.yourpc.entity.Item;
import com.yourpc.entity.User;
import com.yourpc.service.BillableService;

@Service
public class BillableServiceImpl extends GenericServiceImpl<Billable, String> implements BillableService
{
	private BillableDao billableDao;
	
	@Autowired
	public BillableServiceImpl(
			@Qualifier("billableDaoImpl")GenericDao<Billable, String> genericDao)
	{
		super(genericDao);
		this.billableDao = (BillableDao) genericDao;
	}

	@Override
	public void addUserToBillable(User user, Billable billable)
	{
		billableDao.addUserToBillable(user, billable);
	}

	@Override
	public void addBillableToItem(Item item, Billable billable) 
	{
		billableDao.addBillableToItem(item, billable);
	}

	@Override
	public Billable getBillablewithItems(String billableName) 
	{
		return billableDao.getBillablewithItems(billableName);
	}

	@Override
	public void removeUserFromBillable(Billable billable) 
	{
		billableDao.removeUserFromBillable(billable);
	}
}
