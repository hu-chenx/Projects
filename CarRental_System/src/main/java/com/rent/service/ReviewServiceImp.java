package com.rent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rent.dao.ReviewDao;
import com.rent.model.Car;
import com.rent.model.Review;


@Service
public class ReviewServiceImp implements ReviewService{

	@Autowired
	private ReviewDao reviewDao;
	
	@Override
	public void addReview(Review review) {
		// TODO Auto-generated method stub
		reviewDao.addReview(review);
		
	}

	@Override
	public List<Review> getReviewByCar(Car car) {
		// TODO Auto-generated method stub
		return reviewDao.getReviewByCar(car);
	}

}
