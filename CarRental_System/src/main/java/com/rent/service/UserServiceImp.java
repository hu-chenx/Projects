package com.rent.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rent.dao.UserDao;
import com.rent.model.Authorities;
import com.rent.model.Users;


@Service
public class UserServiceImp implements UserService {

	@Autowired
	@Qualifier("userDaoImp")
	private UserDao userDao;
	
	
	@Override
	@Transactional
	public void addUser(Users user) {
		
		userDao.addUser(user);
		
	}

	@Override
	@Transactional
	public void addAuth(Authorities auth) {
		// TODO Auto-generated method stub
		
		userDao.addAuth(auth);
		
	}

	@Override
	@Transactional
	public List<Users> findAll() {
		return userDao.findAll();
	}

	@Override
	public Users findLatest() {
		// TODO Auto-generated method stub
		return userDao.findLatest();
	}

	@Override
	public Users findByName(String username) {
		// TODO Auto-generated method stub
		return userDao.findByName(username);
	}

	

}
