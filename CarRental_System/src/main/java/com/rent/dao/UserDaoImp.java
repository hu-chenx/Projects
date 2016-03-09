package com.rent.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rent.model.Authorities;
import com.rent.model.Users;


@Repository
@Qualifier("userDaoImp")
public class UserDaoImp implements UserDao{
	
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUser(Users user) {
		
		sessionFactory.getCurrentSession().save(user);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void addAuth(Authorities auth) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().saveOrUpdate(auth);
		sessionFactory.getCurrentSession().flush();
		
	}

	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Users").list();
	}

	@Override
	public Users findLatest() {
		// TODO Auto-generated method stub
		return (Users) sessionFactory.getCurrentSession().createQuery("from Users order by id DESC").setMaxResults(1).uniqueResult();
	}

	@Override
	public Users findByName(String username) {
		// TODO Auto-generated method stub
		
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Users.class);
		
		criteria.add(Restrictions.eqOrIsNull("username", username));
		
		return (Users) criteria.uniqueResult();
	}


}
