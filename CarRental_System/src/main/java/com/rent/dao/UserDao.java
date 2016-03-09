package com.rent.dao;

import java.util.List;


import com.rent.model.Users;

import com.rent.model.Authorities;



public interface UserDao {
	

	public void addUser(Users user);
	
	public void addAuth(Authorities auth);
	
	public List<Users> findAll();
	
	public Users findLatest();
	
	public Users findByName(String username); 
}
