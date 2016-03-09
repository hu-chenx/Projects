package com.rent.dao;

import java.util.List;

import com.rent.model.Client;

public interface ClientDao {
	
	public List<Client> findAll();
	
	public Client findById(int id);
	
	public Client findByName(String username);
	
	public void addClient(Client client);
	
	public Client findLatest();
	

}
