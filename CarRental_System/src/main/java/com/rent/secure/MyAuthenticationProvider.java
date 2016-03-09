package com.rent.secure;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.rent.model.Client;
import com.rent.service.ClientService;

public class MyAuthenticationProvider implements AuthenticationProvider{

	 @Autowired
	    @Qualifier("clientServiceImp")
	public ClientService clientService;
	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		
		System.out.print(username);
		
        String password = (String) authentication.getCredentials();
        
         Client client= clientService.findByName(username);
	
		
		return null;
	}


	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
