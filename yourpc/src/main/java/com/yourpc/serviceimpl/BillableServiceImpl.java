package com.yourpc.serviceimpl;

import java.util.List;
import java.util.Set;

import com.yourpc.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yourpc.dao.BillableDao;
import com.yourpc.entity.Billable;
import com.yourpc.entity.Item;
import com.yourpc.service.BillableService;

@Service
public class BillableServiceImpl implements BillableService
{
	private final BillableDao billableDao;

	private final Validator validator;

	@Autowired
	public BillableServiceImpl(BillableDao billableDao, @Qualifier("billableValidator") Validator validator)
	{
		this.billableDao = billableDao;
		this.validator = validator;
	}

	public void add(Billable billable) throws Exception
    {
	    validator.validate(billable);
		billableDao.save(billable);
	}

	public void delete(int id) 
	{
		billableDao.delete(id);
	}

	public void update(Billable billable) 
	{
		billableDao.save(billable);
	}

	public Billable getOne(int id) 
	{
		return billableDao.findOne(id);
	}

	public List<Billable> getAll() 
	{
		return billableDao.findAll();
	}

	public Set<Billable> getBillableWithItems()
	{
		return billableDao.getBillableWithItems();
	}
}
