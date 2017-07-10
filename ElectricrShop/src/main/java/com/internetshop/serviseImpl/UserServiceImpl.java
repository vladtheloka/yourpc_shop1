package com.internetshop.serviseImpl;

import java.util.List;

import com.internetshop.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.internetshop.dao.UserDao;
import com.internetshop.entity.User;
import com.internetshop.service.UserService;
import com.internetshop.validator.Validator;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserDao userDao;
	@Autowired
	@Qualifier("userValidator")
	private Validator validator;
	@Autowired
	private BCryptPasswordEncoder encoder;

	public void save(User user) throws Exception {
		validator.validate(user);
		user.setRole(Role.ROLE_USER);
		user.setPassword(encoder.encode(user.getPassword()));
		userDao.save(user);
	}

	public List<User> findAll() {

		return userDao.findAll();
	}

	public User findOne(int id) {

		return userDao.findOne(id);
	}

	public void delete(int id) {
		userDao.delete(id);

	}

	public void update(User user) throws Exception 
	{
		validator.validate(user);
		userDao.save(user);
	}



	@Override
	public void updateConf(User user) {
		userDao.save(user);
	}

	@Override
	public User findByUuid(String uuid) {
		return userDao.findByUuid(uuid);
	}

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		return userDao.findByName(name);
	}

	@Override
	public User userWithCommodyties(int id) {
		return userDao.userWithCommodyties(id);
	}
}
