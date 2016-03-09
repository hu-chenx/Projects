package com.rent.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import javax.persistence.criteria.Expression;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rent.model.Car;
import com.rent.model.CarAddInfo;

@Repository
public class CarDaoImp implements CarDao{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
		
//begindate<=:begin and enddate>=:end and 
	@Override
	@Transactional
	public void saveCar(CarAddInfo car) {
		// TODO Auto-generated method stub
		
		Car carInsert=new Car();
		
	 Date date_1=new Date(car.getBegindate());
	 
	 Date date_2=new Date(car.getEnddate());
	 
	 int range=(int) ((date_2.getTime()-date_1.getTime())/(24*60*60*1000));
	 
	 System.out.println("range:"+range);
	 
	 float total=range*(Float.parseFloat(car.getPrice()));
	 
	 System.out.println("total:"+total);
	 
	 carInsert.setId(car.getId());
	 carInsert.setBegindate(date_1);
	 carInsert.setBrand(car.getBrand());
	 carInsert.setDetails(car.getDetails());
	 carInsert.setEnddate(date_2);
	 carInsert.setLocation(car.getLocation());
	 carInsert.setMemprice(car.getMemprice());
	 carInsert.setPhoto(car.getPhoto());
	 carInsert.setPhotoBytes(car.getPhotoBytes());
	 carInsert.setPhotoContentType(car.getPhotoContentType());
	 carInsert.setPhotoFilename(car.getPhotoFilename());
	 carInsert.setPrice(car.getPrice());
	 carInsert.setStreet(car.getStreet());
	 carInsert.setTotal(total+"");
	 carInsert.setType(car.getType());
	 carInsert.setUseTime(range+"");
	 carInsert.setZipcode(car.getZipcode());
		
		sessionFactory.getCurrentSession().saveOrUpdate(carInsert);
		sessionFactory.getCurrentSession().flush();
		
	}



@Override
@Transactional
public List<Car> findByDateAndZip(String begindate, String enddate, String zipcode) {
	// TODO Auto-generated method stub
	Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Car.class);
	
Date begin=new Date(begindate);
Date end=new Date(enddate);


   
	
	Conjunction con = Restrictions.conjunction();
	con.add(Restrictions.eq("zipcode",zipcode));
	con.add(Restrictions.between("begindate", begin, end));
    con.add(Restrictions.between("enddate", begin, end));
	
	criteria.add(con);
    
 
    
	// System.out.println(criteria.list().toString());
    return criteria.list();
    
   
}



@Override
@Transactional
public Car findByid(int id) {
	// TODO Auto-generated method stub
	return (Car) sessionFactory.getCurrentSession().get(Car.class, id);
}



@Override
@Transactional
public List<Car> findAll() {
	// TODO Auto-generated method stub
	return sessionFactory.getCurrentSession().createQuery("from Car").list();
}



@Override
@Transactional
public void DeleteCarById(int id) {
	// TODO Auto-generated method stub
	Car car=(Car) sessionFactory.getCurrentSession().load(Car.class, id);
	
	sessionFactory.getCurrentSession().delete(car);
	
	sessionFactory.getCurrentSession().flush();
}



@Override
@Transactional
public CarAddInfo findCarInfoById(int id) {
	// TODO Auto-generated method stub
	Car car=(Car) sessionFactory.getCurrentSession().get(Car.class, id);
	
	CarAddInfo carAddInfo=new CarAddInfo();
	
	Date date_1=car.getBegindate();
    String begindate=(date_1.getYear()+1900)+"/"+(date_1.getMonth()+1)+"/"+date_1.getDate();
    System.out.println("begindate:"+begindate);
    Date date_2=car.getEnddate();
    String enddate=(date_2.getYear()+1900)+"/"+(date_2.getMonth()+1)+"/"+date_2.getDate();
    System.out.println("enddate："+enddate);
    carAddInfo.setId(car.getId());
    carAddInfo.setBegindate(begindate);
    carAddInfo.setEnddate(enddate);
    carAddInfo.setBrand(car.getBrand());
    carAddInfo.setDetails(car.getDetails());
    carAddInfo.setLocation(car.getLocation());
    carAddInfo.setPrice(car.getPrice());
    carAddInfo.setStreet(car.getStreet());
    carAddInfo.setTotal(car.getTotal());
    carAddInfo.setType(car.getType());
    carAddInfo.setZipcode(car.getZipcode());
  


    return carAddInfo;

}

}
