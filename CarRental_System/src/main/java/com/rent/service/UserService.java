package com.rent.service;

import java.util.List;

import com.rent.model.Authorities;
import com.rent.model.Users;

public interface UserService {
	
public void addUser(Users user);
	
	public void addAuth(Authorities auth);
	
	public List<Users> findAll();
	
	public Users findLatest();
	
	public Users findByName(String username); 
	
}
