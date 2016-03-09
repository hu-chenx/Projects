package com.rent.service;

import java.util.List;

import com.rent.model.Car;
import com.rent.model.Review;

public interface ReviewService {
	

	public void addReview(Review review);
	
	public List<Review> getReviewByCar(Car car);

}
