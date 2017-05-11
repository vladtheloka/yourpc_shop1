package com.yourpc.dao;

import java.util.List;

public interface GenericDao<T, K>
{
	T add(T entity);
	void delete(K fieldName, K fieldValue);
    T update(T entity);
	T getOne(K fieldName, K fieldValue);
	List<T> getAll();
}
