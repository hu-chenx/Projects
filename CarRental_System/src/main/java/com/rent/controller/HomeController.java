package com.rent.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.security.auth.login.LoginContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rent.model.Car;
import com.rent.model.Client;
import com.rent.model.Message;
import com.rent.model.SearchInfo;
import com.rent.model.Users;
import com.rent.service.CarServiceImp;
import com.rent.service.MSService;
import com.rent.service.UserServiceImp;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	@Autowired
	private CarServiceImp carServiceImp;
	
	
	@Autowired
	@Qualifier("userServiceImp")
	private UserServiceImp userservice;
	
	
	@Autowired
	private MSService msService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		/*logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		*/
		return "home";
	}
	
	
	@RequestMapping(value="/log_in")
	public ModelAndView Login(@RequestParam(value = "error", required = false) String error)
	{
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}
		model.setViewName("login");
		 
		return model;
		
	}
	
	
	
	@RequestMapping(value="/")
	public String searchAndView(Model model)
	{
		model.addAttribute("searchInfo",new SearchInfo());
		
        /*Car car=new Car();
		
		car.setBegindate(new Date("2015/10/24"));
		
       carServiceImp.saveCar(car);
		*/
		
		return "home";
		
		
		
	}
	
	
	
	@RequestMapping(value="/search")
	public ModelAndView search(@Valid SearchInfo searchInfo, BindingResult bindingResult,Model model)
	{
		ModelAndView mav = new ModelAndView("home");
		
		if(bindingResult.getErrorCount()>0)
		{
			return mav;
		}
		
		List<Car> cars=
				
		carServiceImp.findByDateAndZip(searchInfo.getBegindate(), searchInfo.getEnddate(), searchInfo.getZipCode());
				
		
		System.out.println(cars.isEmpty());
		
		if(cars.isEmpty())
		{
			mav.addObject("info","No Matched Result!");
		}
		
		mav.addObject("cars",cars);
		
		return mav;
	}
	
	
	@RequestMapping(value="/info/{id}")
	public ModelAndView CarInfo(@PathVariable int id)
	{
		
		Car car=carServiceImp.findByid(id);
		
		
	    
		ModelAndView mav = new ModelAndView("CarInfo");
		
		mav.addObject("car", car);
		
		return mav;
		
	}
	
	@RequestMapping(value="/denied")
	public String Deny()
	{
		return "redirect:/log_in";
	}
	
	
	
	
	@RequestMapping(value="/login")
	public ModelAndView Error(@RequestParam (value="error",required=false) String error)
	
	{
		ModelAndView mav=new ModelAndView("login");		
		
		if(error!=null)
		{
			mav.addObject("error", "Invalid username and password!");
		}
		
		return mav;
	}
	
	
	@RequestMapping("/dispatch")
	public String dispatch(Model model,Authentication authentication,HttpServletRequest request)
	{
		
		
		 String username = authentication.getName();
			
	     System.out.print("username:"+username);
	
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String role=null;
		
		for( GrantedAuthority ga: userDetails.getAuthorities()){ 
			role = ga.getAuthority();
		}
		
		Users users=userservice.findByName(username);
	   
		model.addAttribute("users", users);
		
		//System.out.println("username:"+users.getUsername());
	           
		model.addAttribute("searchInfo",new SearchInfo());
		
		
	    Client client=users.getClient();
		
	    List<Message> messages=msService.getMessageByClientAndStatus(client);
	    
	   // System.out.println("firstname:"+client.getFirstname());
	    
	   // System.out.println(messages.iterator().next().getMessage());
	    
	    model.addAttribute("messages", messages);
	    
		if(role.equals("ROLE_USER"))return "userPage";
		
		else if(role.equals("ROLE_ADMIN"))return "adminPage";
		
		else return "login";
		
		
	}
	
	
	@RequestMapping(value="/{id}/photo", method=RequestMethod.GET)
	public @ResponseBody String viewPhoto(@PathVariable int id, HttpServletResponse response) throws IOException
	{
		Car car=carServiceImp.findByid(id);
		byte[] CarPhotoBytes = car.getPhotoBytes();
		if (CarPhotoBytes != null) {
			int CarPhotoLength = CarPhotoBytes.length;
			try (ServletOutputStream sos = response.getOutputStream()) {
				response.setContentType(car.getPhotoContentType());
				response.setContentLength(CarPhotoLength);
				response.setHeader("Content-Disposition", "inline; filename=\"" + car.getPhotoFilename() + "\"");
				
				sos.write(CarPhotoBytes);
				sos.flush();
			}
		}
		
		return "";
	}
}
