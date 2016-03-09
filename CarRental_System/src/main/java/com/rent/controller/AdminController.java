package com.rent.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rent.model.Car;
import com.rent.model.CarAddInfo;
import com.rent.model.Client;
import com.rent.model.Message;
import com.rent.model.Review;
import com.rent.model.SearchInfo;
import com.rent.model.ShopCart;
import com.rent.model.Users;
import com.rent.service.CarService;
import com.rent.service.ClientService;
import com.rent.service.MSService;
import com.rent.service.ReviewService;
import com.rent.service.UserService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private MSService mssservice;
	
		
		
	@RequestMapping(value="/searchCar")
	public ModelAndView search(@Valid SearchInfo searchInfo, BindingResult bindingResult,Model model,Authentication authentication)
	{
	
	String username = authentication.getName();
	System.out.println(username);
	
	Users users=userService.findByName(username);
	
	ModelAndView mav = new ModelAndView("adminPage");
	
	if(bindingResult.getErrorCount()>0)
	{
		return mav;
	}
	
	List<Car> car=
			
	carService.findByDateAndZip(searchInfo.getBegindate(), searchInfo.getEnddate(), searchInfo.getZipCode());
			
	System.out.println(car.iterator().hasNext());
	
	
	
	if(car.isEmpty())
	{
		mav.addObject("information","No Matched Result!");
	}
	mav.addObject("users", users);
	mav.addObject("cars",car);
	
	return mav;
}
	
	
	@RequestMapping(value="process/{id}")
	public ModelAndView Display(@PathVariable int id,Authentication authentication)
	{
		String username = authentication.getName();
		
		Users users=userService.findByName(username);
		
		ModelAndView mav = new ModelAndView("AdminCarInfo");
		
		Car car=carService.findByid(id);
		
		List<Review> reviews= reviewService.getReviewByCar(car);
		
		mav.addObject("reviews", reviews);
		
		mav.addObject("users", users);
		
		mav.addObject("car",car);
		
		return mav;
	}
	
	@RequestMapping(value="/")
	public String GoOnSearch(Model model,Authentication authentication)
	{
		String username=authentication.getName();
		
		Users users=userService.findByName(username);
		
		model.addAttribute("users", users);
		
		model.addAttribute("searchInfo",new SearchInfo());
		
		return "adminPage";
	}
	
	@RequestMapping(value="/AddCar")
	public String ToAddCarPage(Model model,Authentication authentication)
	{
        String username=authentication.getName();
		
		Users users=userService.findByName(username);
		
		model.addAttribute("users", users);
		
		model.addAttribute("carAddInfo", new CarAddInfo());
		
		return "AddCar";
	}
	
	@RequestMapping(value="/add")
	public String AddCar(@ModelAttribute @Valid CarAddInfo carAddInfo,BindingResult bindingResult,Authentication authentication,Model model)
	{
		System.out.println(carAddInfo.getBegindate());
		
		
	    String username=authentication.getName();
		
			Users users=userService.findByName(username);
		
		model.addAttribute("users", users);
		
		if(bindingResult.getErrorCount()>0)
		{
			
			
			return "AddCar";
		}
		
		
		carService.saveCar(carAddInfo);
		
		return "redirect:/admin/listCar";
	}
	
	
	
	
	@RequestMapping(value="/listCar")
	public String listCar(Authentication authentication,Model model)
	{
        String username=authentication.getName();
		
		Users users=userService.findByName(username);
		
		model.addAttribute("users", users);
		
	    List<Car> cars=carService.findAll();
	    
	    if(cars.isEmpty())
	    {
	    	model.addAttribute("information", "No Car Available Now!");
	    }
	    
	    model.addAttribute("cars",cars);
	    
	    return "listCar";
	}
	
	@RequestMapping(value="/edit/{id}")
	public String EditCar(Model model,Authentication authentication,@PathVariable int id)
	{
         String username=authentication.getName();
		
		Users users=userService.findByName(username);
		
		CarAddInfo carAddInfo=carService.findCarInfoById(id);
		
		model.addAttribute("users", users);
		
		model.addAttribute("carAddInfo", carAddInfo);
		
		return "AddCar";
		
		
	}
	
	
	@RequestMapping(value="/delete/{id}")
	public String DeleteCar(Model model,Authentication authentication,@PathVariable int id)
	{
        String username=authentication.getName();
		
		Users users=userService.findByName(username);
		
		model.addAttribute("users", users);
		
		carService.DeleteCarById(id);
		
		return "redirect:/admin/listCar";
		
	}
	
	@RequestMapping(value="/listUser")
	public String ListClient(Model model,Authentication authentication)
	{
		  String username=authentication.getName();
			
			Users users=userService.findByName(username);
			
			model.addAttribute("users", users);
			
			List<Client> clients=clientService.findAll();
			
			if(clients.isEmpty())
			{
				model.addAttribute("information", "No Client Registered!");
			}
			
			model.addAttribute("clients", clients);
			
		    return "listUser";
		
		
	}
	
	@RequestMapping(value="/ViewAndSend/{id}")
	public String ViewAndSend(@PathVariable int id,Authentication authentication,Model model)
	{
		String username=authentication.getName();
		
		Users users=userService.findByName(username);
		
		model.addAttribute("users", users);
		
		Client client=clientService.findById(id);
		
		List<ShopCart> shopCarts=mssservice.getAllPlacedOrderByClient(client);
		
		model.addAttribute("shopcarts", shopCarts);
		
		model.addAttribute("client", client);
		
		return "writeMessage";
		
		
		
	}
	
	
	@RequestMapping(value="/WriteToClient/{id}")
	public String WriteToClient(@ModelAttribute Message message,Authentication authentication,Model model,@PathVariable int id)
	{
        String username=authentication.getName();
		
		Users users=userService.findByName(username);
		
		model.addAttribute("users", users);
		
		Client client=clientService.findById(id);
		
		message.setClient(client);
		
		mssservice.addMessage(message);
		
		return "redirect:/admin/listUser";
	}
	
	@RequestMapping(value="/{id}/photo", method=RequestMethod.GET)
	public @ResponseBody String viewPhoto(@PathVariable int id, HttpServletResponse response) throws IOException
	{
		Car car=carService.findByid(id);
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
	

	
	@RequestMapping(value="/ViewMessage")
	public String ViewMessage(Model model,Authentication authentication)
	{
		
		 String username = authentication.getName();
			
	        Users users=userService.findByName(username);
	        
	        model.addAttribute("users", users);
	        
	        Client client=users.getClient();
	        
	        List<Message> messages=mssservice.getMessageByClientAndStatus(client);
	        
	        model.addAttribute("messages", messages);
	        
	        return "AdminViewMessage";
		
	}
	
	
	
	@RequestMapping(value="/reply/{id}")
	public String Reply(@PathVariable int id,@ModelAttribute Message message)
	{
		
		Message send=mssservice.getMessageById(id);
		
		send.setStatus("read");
		
		Users users=userService.findByName(message.getReceiver());
		
		Client client = users.getClient();
		
		message.setClient(client);
		
		mssservice.UpdateMessage(send);
		
		mssservice.addMessage(message);
		
		return "redirect:/admin/ViewMessage";
		
		
	}
	
}