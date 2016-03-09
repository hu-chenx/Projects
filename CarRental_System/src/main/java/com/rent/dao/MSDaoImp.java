package com.rent.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rent.model.Client;
import com.rent.model.Message;
import com.rent.model.ShopCart;

@Repository
@Transactional
public class MSDaoImp implements MSDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	@Transactional
	public void addShopCart(ShopCart shopCart) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(shopCart);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	@Transactional
	public void deleteShopCartById(int id) {
		// TODO Auto-generated method stub
		ShopCart shopCart= (ShopCart) sessionFactory.getCurrentSession().load(ShopCart.class, id);
		
		sessionFactory.getCurrentSession().delete(shopCart);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	@Transactional
	public List<ShopCart> getAllPendingByClient(Client client) {
		// TODO Auto-generated method stub
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(ShopCart.class);
		
		Conjunction conjunction= Restrictions.conjunction();
		conjunction.add(Restrictions.eqOrIsNull("status", "pending"));
		conjunction.add(Restrictions.eqOrIsNull("client", client));
		
		criteria.add(conjunction);
		
		return criteria.list();
		
	}

	

	@Override
	@Transactional
	public List<ShopCart> getAllPlacedOrderByClient(Client client) {
		// TODO Auto-generated method stub
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(ShopCart.class);
		
		Conjunction conjunction=Restrictions.conjunction();
		
		conjunction.add(Restrictions.eqOrIsNull("status", "placed"));
		conjunction.add(Restrictions.eqOrIsNull("client", client));
		criteria.add(conjunction);
		
		return criteria.list();
	}

	@Override
	@Transactional
	public void addMessage(Message message) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(message);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	@Transactional
	public List<Message> getMessageByClient(Client client) {
		// TODO Auto-generated method stub
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Message.class);
		
	    criteria.add(Restrictions.eq("client", client));
	    
	    return criteria.list();
	}

	@Override
	@Transactional
	public List<Message> getMessageByClientAndStatus(Client client) {
		// TODO Auto-generated method stub
		
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Message.class);
		
		Conjunction conjunction=Restrictions.conjunction();
		
		conjunction.add(Restrictions.eq("status", "pending"));
		conjunction.add(Restrictions.eq("client", client));
		
		criteria.add(conjunction);
		
		return criteria.list();
	}

	@Override
	@Transactional
	public Message getMessageById(int id) {
		// TODO Auto-generated method stub
		return (Message) sessionFactory.getCurrentSession().get(Message.class, id);
	}

	@Override
	@Transactional
	public void UpdateMessage(Message message) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(message);
		
	}

	
	


	

}
