package com.rent.dao;

import java.util.List;

import javax.transaction.TransactionManager;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rent.model.Client;


@Repository
@Transactional
public class ClientDaoImp implements ClientDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Client").list();
	}

	@Override
	@Transactional
	public Client findById(int id) {
		// TODO Auto-generated method stub
		return (Client) sessionFactory.getCurrentSession().get(Client.class, id);
	}

	@Override
	@Transactional
	public Client findByName(String firstname) {
		// TODO Auto-generated method stub
		return (Client) sessionFactory.getCurrentSession().createQuery("from Client where firstname=:name").setParameter("name", firstname);
	}

	@Override
	@Transactional
	public void addClient(Client client) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(client);
		
	}

	@Override
	@Transactional
	public Client findLatest() {
		// TODO Auto-generated method stub
		return (Client) sessionFactory.getCurrentSession().createQuery("from Client order by id DESC").setMaxResults(1).uniqueResult();
	}

}
