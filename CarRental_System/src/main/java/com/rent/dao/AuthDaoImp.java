package com.rent.dao;

import java.util.function.Predicate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rent.model.Authorities;


@Repository
public class AuthDaoImp implements AuthDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void addAuth(Authorities authorities) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().save(authorities);
		sessionFactory.getCurrentSession().flush();
		
	}

}
