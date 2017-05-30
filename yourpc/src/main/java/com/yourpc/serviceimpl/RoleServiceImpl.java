package com.yourpc.serviceimpl;

import java.util.List;
import com.yourpc.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yourpc.dao.RoleDao;
import com.yourpc.dao.UserDao;
import com.yourpc.entity.Role;
import com.yourpc.entity.User;
import com.yourpc.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService 
{
	private final RoleDao roleDao;
	
	private final UserDao userDao;

    private final Validator validator;

	@Autowired
	public RoleServiceImpl(RoleDao roleDao, UserDao userDao, @Qualifier("roleValidator") Validator validator)
    {
		this.roleDao = roleDao;
		this.userDao = userDao;
        this.validator = validator;
    }

	public void add(Role role) throws Exception {
		validator.validate(role);
		roleDao.save(role);
	}

	public void delete(int id) 
	{
		Role role = roleDao.roleWithUser(id);
        for (User user: role.getUser())
        {
            user.setRole(null);
            userDao.saveAndFlush(user);
        }
        roleDao.delete(id);
	}

	public void update(Role role) 
	{
		roleDao.save(role);	
	}

	public Role getOne(int id)
	{
		return roleDao.findOne(id);
	}

	public List<Role> getAll() 
	{
		return roleDao.findAll();
	}

}
