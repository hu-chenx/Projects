package com.rent.dao;

import java.util.Date;
import java.util.List;

import com.rent.model.Car;
import com.rent.model.CarAddInfo;

public interface CarDao {
	
	
	public List<Car> findByDateAndZip(String begindate,String enddate,String zipcode);
	
	public void saveCar(CarAddInfo car);
	
	public Car findByid(int id);
	
	public List<Car> findAll();
	
	public void DeleteCarById(int id);
	
	public CarAddInfo findCarInfoById(int id);

}
