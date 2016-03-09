package com.rent.dao;

import java.util.List;

import com.rent.model.Client;
import com.rent.model.Message;
import com.rent.model.Review;
import com.rent.model.ShopCart;

public interface MSDao {

	
	public List<ShopCart> getAllPendingByClient(Client client);
	

	
	public List<ShopCart> getAllPlacedOrderByClient(Client client);
	
	public void addShopCart(ShopCart shopCart);
	
	public void deleteShopCartById(int id);
	
	public void addMessage(Message message);
	
	public List<Message> getMessageByClient(Client client);
	
	public List<Message> getMessageByClientAndStatus(Client client);
	
	public Message getMessageById(int id);
	
	public void UpdateMessage(Message message);
	
}
