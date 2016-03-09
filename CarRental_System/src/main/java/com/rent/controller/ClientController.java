package com.rent.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.cfg.Settings;
import org.hibernate.sql.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rent.dao.UserDao;
import com.rent.dao.UserDaoImp;
import com.rent.model.Authorities;
import com.rent.model.Client;
import com.rent.model.SearchInfo;
import com.rent.model.Users;
import com.rent.service.AuthServiceImp;
import com.rent.service.ClientService;
import com.rent.service.ClientServiceImp;
import com.rent.service.UserService;
import com.rent.service.UserServiceImp;

@Controller
@RequestMapping("/authenticate")
public class ClientController {
	
	

	@Autowired
	@Qualifier("clientServiceImp")
	private ClientService service;
	
	
	@Autowired
	@Qualifier("userServiceImp")
	private UserServiceImp userservice;
	
	@Autowired
	private AuthServiceImp authServiceImp;
	
	
	
	
	
	
	@RequestMapping("/register_3")
	public String register_3(Model model)
	{
		model.addAttribute("authorities", new Authorities());
		
		return "register_3";
	}
	
	
	@RequestMapping("/insert_3")
	public String insert_3(@Valid Authorities authorities, BindingResult bindingResult)
	{
		
		if(bindingResult.getErrorCount()>0)
		{
			return "register_3";
		}
		
		Users users = userservice.findLatest();
		
		authorities.setUsers(users);
		
		authServiceImp.addAuth(authorities);
		
		return "redirect:/login";
	}
	
	
	
	
	
	
	
	
	@RequestMapping("/register_2")
	public String register_2(Model model)
	{
		
		
	  model.addAttribute("users",new Users());
	  
	  return "register_2";
	}
	
	
	
	
	@RequestMapping("insert_2")
	public String insert_2(@Valid Users users,BindingResult bindingResult)
	{
		
		if(bindingResult.getErrorCount()>0)
		{
			return "register_2";
		}
		
		Client client=service.findLatest();
		
		
		users.setClient(client);
		
		userservice.addUser(users);
		
		return "redirect:/authenticate/register_3";
	}
	
	
	
	
	
	@RequestMapping("/register")
	public String register(Model model)
	{
		model.addAttribute("client", new Client());
		return "register";
		
		
	}
	
	
	@RequestMapping("insert")
	public String Insert(@Valid Client client,BindingResult bindingResult,Model model)
	{
		if(bindingResult.getErrorCount()>0)
		{
			return "register";
		}
		
		service.addClient(client);
	
		
		return "redirect:/authenticate/register_2";
		
	}
	
  
	
	/*@RequestMapping("/dispatch")
	public String dispatch(Model model,Authentication authentication,HttpServletRequest request)
	{
		
		
		 String username = authentication.getName();
			
	     System.out.print(username);
	
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String role=null;
		
		for( GrantedAuthority ga: userDetails.getAuthorities()){ 
			role = ga.getAuthority();
		}
		
		Users users=userservice.findByName(username);
	   
		model.addAttribute("users", users);
		
		System.out.println(users.getUsername());
	           
		model.addAttribute("searchInfo",new SearchInfo());
		
		if(role.equals("ROLE_USER"))return "userPage";
		
		else if(role.equals("ROLE_ADMIN"))return "adminPage";
		
		else return "login";
		
		
	}*/
	
}   
