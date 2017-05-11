package com.yourpc.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yourpc.dao.GenericDao;
import com.yourpc.service.GenericService;

@Service
public abstract class GenericServiceImpl<T, K> implements GenericService<T, K>{
	

	private GenericDao<T, K> genericDao;
	
	public GenericServiceImpl(GenericDao<T, K> genericDao) 
	{
		this.genericDao = genericDao;
	}
	
	public GenericServiceImpl(){}

	@Override
	public T add(T entity)
	{
		return genericDao.add(entity);
	}

	@Override
	public void delete(K fieldName, K fieldValue) 
	{
		genericDao.delete(fieldName, fieldValue);
	}

	@Override
	public T update(T entity)
	{
		return genericDao.update(entity);
	}

	@Override
	public T getOne(K fieldName, K fieldValue) 
	{
		return genericDao.getOne(fieldName, fieldValue);
	}

	@Override
	public List<T> getAll()
	{
		return genericDao.getAll();
	}
}
