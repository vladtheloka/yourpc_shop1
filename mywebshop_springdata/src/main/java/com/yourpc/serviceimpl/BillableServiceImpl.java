package com.yourpc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourpc.dao.BillableDao;
import com.yourpc.entity.Billable;
import com.yourpc.service.BillableService;

@Service
public class BillableServiceImpl implements BillableService
{
	@Autowired
	private BillableDao billableDao;

	@Override
	public void add(Billable billable) 
	{
		billableDao.save(billable);
	}

	@Override
	public void delete(int id) 
	{
		billableDao.delete(id);
	}

	@Override
	public void update(Billable billable) 
	{
		billableDao.save(billable);
	}

	@Override
	public Billable getOne(int id) 
	{
		return billableDao.findOne(id);
	}

	@Override
	public List<Billable> getAll() 
	{
		return billableDao.findAll();
	}
}
