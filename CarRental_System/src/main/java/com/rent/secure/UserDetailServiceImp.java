package com.rent.secure;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rent.dao.ClientDao;
import com.rent.dao.ClientDaoImp;
import com.rent.model.Client;
import com.rent.service.ClientService;
import com.rent.service.ClientServiceImp;



public class UserDetailServiceImp implements UserDetailsService{


    @Autowired
    @Qualifier("clientServiceImp")
public ClientService clientService;
	
 


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.print(username);
		
		Client client = clientService.findByName(username);
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		if(client==null)
		{
			throw new UsernameNotFoundException("No such User"+username);
			
			
		}
		
	return null;
		
	
	
		
	}
	
	

}
