package com.rent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rent.dao.AuthDao;
import com.rent.model.Authorities;


@Service
public class AuthServiceImp implements AuthService{

	@Autowired
	private AuthDao authDao;
	
	@Override
	@Transactional
	public void addAuth(Authorities authorities) {
		// TODO Auto-generated method stub
		authDao.addAuth(authorities);
		
	}

	
	
}
