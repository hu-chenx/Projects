package com.rent.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rent.model.Client;
import com.rent.model.Message;
import com.rent.model.Review;
import com.rent.model.SearchInfo;
import com.rent.dao.MSDao;
import com.rent.model.Car;
import com.rent.model.ShopCart;
import com.rent.model.Users;
import com.rent.service.CarService;
import com.rent.service.CarServiceImp;
import com.rent.service.ClientService;
import com.rent.service.MSService;
import com.rent.service.ReviewService;
import com.rent.service.ReviewServiceImp;
import com.rent.service.UserService;
import com.rent.service.UserServiceImp;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private MSService msservice;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private CarServiceImp carServiceImp;
	
	@Autowired
	@Qualifier("userServiceImp")
	private UserServiceImp userservice;
	
	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping(value="/add/{id}")
	public String AddToShopCart(@PathVariable int id,Authentication authentication)
	{
		
		String username=authentication.getName();
		System.out.println("username:"+username);
		
		Users users=userservice.findByName(username);
		
		Client client=users.getClient();
        System.out.println("firstname:"+client.getFirstname());
		
		
		Car car=carServiceImp.findByid(id);
		
		ShopCart shopCart=new ShopCart();
		
		shopCart.setBegindate(car.getBegindate());
		shopCart.setBrand(car.getBrand());
		shopCart.setClient(client);
		shopCart.setEnddate(car.getEnddate());
		shopCart.setLocation(car.getLocation());
		shopCart.setStreet(car.getStreet());
		shopCart.setTotal(car.getTotal());
		shopCart.setStatus("pending");
        shopCart.setZipcode(car.getZipcode());
        shopCart.setType(car.getType());
        shopCart.setCar_id(car.getId());
        
        msservice.addShopCart(shopCart);
		
		return "redirect:/user/Viewshopcart";
		
	}
	
	@RequestMapping(value="/searchCar")
	public ModelAndView search(@Valid SearchInfo searchInfo, BindingResult bindingResult,Model model,Authentication authentication)
	{
		
		String username = authentication.getName();
		System.out.println(username);
		
		Users users=userservice.findByName(username);
		
		ModelAndView mav = new ModelAndView("userPage");
		
		if(bindingResult.getErrorCount()>0)
		{
			return mav;
		}
		
		List<Car> car=
				
		carServiceImp.findByDateAndZip(searchInfo.getBegindate(), searchInfo.getEnddate(), searchInfo.getZipCode());
				
		System.out.println(car.iterator().hasNext());
		
		
		
		if(car.isEmpty())
		{
			mav.addObject("information","No Matched Result!");
		}
		mav.addObject("users", users);
		mav.addObject("cars",car);
		
		return mav;
	}
	
	@RequestMapping(value="/process/{id}")
	public ModelAndView Display(@PathVariable int id,Authentication authentication)
	{
		String username = authentication.getName();
		
		Users users=userservice.findByName(username);
		
		Client client=users.getClient();
		
		ModelAndView mav = new ModelAndView("UserCarInfo");
		
		Car car=carServiceImp.findByid(id);
		
		List<Review> reviews= reviewService.getReviewByCar(car);
		
		mav.addObject("client", client);
		
		mav.addObject("reviews", reviews);
		
		mav.addObject("users", users);
		
		mav.addObject("car",car);
		
		return mav;
	}
	
	@RequestMapping(value="Viewshopcart")
	public ModelAndView Viewshopcart(Authentication authentication)
	{
		
		ModelAndView modelAndView = new ModelAndView("shopcart");
		
		String username = authentication.getName();
		
		
		Users users=userservice.findByName(username);
		
		Client client=users.getClient();
		
	    List<ShopCart> shopCart=msservice.getAllPendingByClient(client);
		
		if(shopCart.isEmpty())
		{
			modelAndView.addObject("info","shopping Cart is empty!");
		}
		
		modelAndView.addObject("users", users);
		
		modelAndView.addObject("shopcart",shopCart);
		
		modelAndView.addObject("client", client);
		
		return modelAndView;
	}

	
	@RequestMapping(value="/")
	public String GoOnSearch(Model model,Authentication authentication)
	{
		String username=authentication.getName();
		
		Users users=userservice.findByName(username);
		
		
	
		
	
		model.addAttribute("users", users);
		
		model.addAttribute("searchInfo",new SearchInfo());
		
		return "userPage";
	}
	
	
	
	
	@RequestMapping(value="/cancelOrder/{id}")
	public String DeleteOrder(@PathVariable int id)
	{
		
		msservice.deleteShopCartById(id);
		
		return "redirect:/user/Viewshopcart";
		
	}
	
	
	
	@RequestMapping(value="/checkout")
	public String CheckOut(Authentication authentication,Model model)
	{
		String username = authentication.getName();
	
        Users users=userservice.findByName(username);
		
		Client client=users.getClient();
		
	    List<ShopCart> shopCart=msservice.getAllPendingByClient(client);
	    
	    
	    for(ShopCart shop:shopCart)
	    {
	    
	    	shop.setStatus("placed");
	    	
	        msservice.addShopCart(shop);
	    }
	    
	    model.addAttribute("checkout","successfully check out" );
	    model.addAttribute("users",users);
	    
	   return "shopcart";
		
	}
	
	
	
	@RequestMapping(value="/ViewHistory")
	public ModelAndView ViewHistory(Authentication authentication)
	{
		ModelAndView modelAndView = new ModelAndView("history");
		
		String username = authentication.getName();
		
        Users users=userservice.findByName(username);
        
        Client client=users.getClient();
		
	
		
		List<ShopCart> history=msservice.getAllPlacedOrderByClient(client);
		
		if(history.isEmpty())
		{
			modelAndView.addObject("info", "No Reservation History");
		}
		modelAndView.addObject("users", users);
		modelAndView.addObject("history", history);
		modelAndView.addObject("client", client);
		
		return modelAndView;
		
		
	}
	
	@RequestMapping(value="/writeReview/{id}")
	public String WriteReview(@PathVariable int id,Model model,Authentication authentication)
	{
        String username = authentication.getName();
		
        Users users=userservice.findByName(username);
		
		model.addAttribute("review", new Review());
		
		Car car=carServiceImp.findByid(id);
		model.addAttribute("users", users);
		model.addAttribute("car", car);
		
		return "writeReview";
	}
	
	@RequestMapping(value="/write/{id}")
	public String WriteAndPost(Review review,BindingResult bindingResult,
			@PathVariable int id,Model model,Authentication authentication)
	{
		
		if(bindingResult.getErrorCount()>0)
		{
			return "writeReview";
		}
		String username=authentication.getName();
		
		Users users=userservice.findByName(username);
		
		Car car=carServiceImp.findByid(id);
		
		review.setCar(car);
		
		reviewService.addReview(review);
		
		List<Review> reviews=reviewService.getReviewByCar(car);
	
		model.addAttribute("car", car);
		model.addAttribute("reviews", reviews);
		
		return "UserCarInfo";
	}
	
	
	
	@RequestMapping(value="/profile/{id}")
	public ModelAndView DisplayUserProfileAndMessage(@PathVariable int id,Authentication authentication)
	{
	  ModelAndView modelAndView=new ModelAndView("UserProfile");
		
        String username = authentication.getName();
		
        Users users=userservice.findByName(username);
        
        modelAndView.addObject("users", users);
        
        Client client=clientService.findById(id);
        
        List<Message> messages=msservice.getMessageByClientAndStatus(client);
        
        List<ShopCart> shopCarts=msservice.getAllPlacedOrderByClient(client);
        
        if(messages.isEmpty())
        {
        	modelAndView.addObject("information", "no new message!");
        }
        
        modelAndView.addObject("client", client);
        
        modelAndView.addObject("messages", messages);
        
        modelAndView.addObject("shopcarts", shopCarts);
        
        return modelAndView;
	}
	
	
	@RequestMapping(value="/reply/{id}")
	public String Reply(@PathVariable int id,@ModelAttribute Message message)
	{
		
		String username=message.getSender();
		Users thisUser=userservice.findByName(username);
		
		
		Message send=msservice.getMessageById(id);
		
		send.setStatus("read");
		
		Users users=userservice.findByName(message.getReceiver());
		
		
		
		Client client = users.getClient();
		
		message.setClient(client);
		
		msservice.UpdateMessage(send);
		
		msservice.addMessage(message);
		
		return "redirect:/user/profile/"+thisUser.getClient().getId()+"";
		
		
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
