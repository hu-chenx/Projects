package com.rent.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rent.dao.ClientDao;
import com.rent.dao.ClientDaoImp;
import com.rent.model.Client;


@Service
public class ClientServiceImp implements ClientService{
	
	@Autowired
	@Qualifier("clientDaoImp")
	private ClientDao clientDao;
	


	@Override
	public List<Client> findAll() {
		
		return clientDao.findAll();
	}

	@Override
	public Client findById(int id) {

		return clientDao.findById(id);
	}

	@Override
	public Client findByName(String username) {
		// TODO Auto-generated method stub
		return clientDao.findByName(username);
	}

	@Override
	public void addClient(Client client) {
		
		
		clientDao.addClient(client);
		
	}

	@Override
	public Client findLatest() {
		// TODO Auto-generated method stub
		return clientDao.findLatest();
	}

	

}
