package com.rent.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rent.model.Car;
import com.rent.model.Review;

@Repository
@Transactional
public class ReviewDaoImp implements ReviewDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void addReview(Review review) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(review);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	@Transactional
	public List<Review> getReviewByCar(Car car) {
		// TODO Auto-generated method stub
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Review.class);
		
		criteria.add(Restrictions.eqOrIsNull("car", car));
		
		return criteria.list();
	}

	

}
