package com.yourpc.serviceimpl;

import java.util.List;

import com.yourpc.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yourpc.dao.BillableDao;
import com.yourpc.dao.UserDao;
import com.yourpc.entity.Billable;
import com.yourpc.entity.User;
import com.yourpc.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	private final UserDao userDao;
	
	private final BillableDao billableDao;

	private final Validator validator;

	@Autowired
	public UserServiceImpl(UserDao userDao, BillableDao billableDao, @Qualifier("userValidator") Validator validator) {
		this.userDao = userDao;
		this.billableDao = billableDao;
        this.validator = validator;
    }

	public void add(User user) throws Exception
    {
	    validator.validate(user);
        userDao.save(user);
	}

	public void delete(int id) 
	{
		User user = userDao.userWithBillables(id);
        for (Billable billable: user.getBillable())
        {
            billable.setUser(null);
            billableDao.saveAndFlush(billable);
        }
		userDao.delete(id);
	}

	public void update(User user) throws Exception
    {
		validator.validate(user);
	    userDao.save(user);
	}

	public User getOne(int id) 
	{
		return userDao.findOne(id);
	}

	public List<User> getAll()
	{
		return userDao.findAll();
	}
}