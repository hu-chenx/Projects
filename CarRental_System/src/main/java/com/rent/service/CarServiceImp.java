package com.rent.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rent.dao.CarDaoImp;
import com.rent.model.Car;
import com.rent.model.CarAddInfo;


@Service
public class CarServiceImp implements CarService{

	@Autowired
	private CarDaoImp carDaoImp;
	

	


	@Override
	public List<Car> findByDateAndZip(String begindate, String enddate, String zipcode) {
		// TODO Auto-generated method stub
		return carDaoImp.findByDateAndZip(begindate, enddate, zipcode);
	}


	@Override
	public Car findByid(int id) {
		// TODO Auto-generated method stub
		return carDaoImp.findByid(id);
	}


	@Override
	public List<Car> findAll() {
		// TODO Auto-generated method stub
		return carDaoImp.findAll();
	}


	@Override
	public void DeleteCarById(int id) {
		// TODO Auto-generated method stub
		carDaoImp.DeleteCarById(id);
	}


	@Override
	public void saveCar(CarAddInfo car) {
		// TODO Auto-generated method stub
		carDaoImp.saveCar(car);
		
	}


	@Override
	public CarAddInfo findCarInfoById(int id) {
		// TODO Auto-generated method stub
		return carDaoImp.findCarInfoById(id);
	}


	

}
