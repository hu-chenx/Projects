package com.rent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rent.dao.MSDao;
import com.rent.model.Client;
import com.rent.model.Message;
import com.rent.model.ShopCart;

@Service
public class MSServiceImp implements MSService{
	
	@Autowired
	private MSDao msDao;

	

	@Override
	public void addShopCart(ShopCart shopCart) {
		// TODO Auto-generated method stub
		
		msDao.addShopCart(shopCart);
		
	}

	@Override
	public void deleteShopCartById(int id) {
		// TODO Auto-generated method stub
		
		msDao.deleteShopCartById(id);
		
	}

	@Override
	public List<ShopCart> getAllPendingByClient(Client client) {
		// TODO Auto-generated method stub
		return msDao.getAllPendingByClient(client);
	}

	@Override
	public List<ShopCart> getAllPlacedOrderByClient(Client client) {
		// TODO Auto-generated method stub
		return msDao.getAllPlacedOrderByClient(client);
	}

	@Override
	public void addMessage(Message message) {
		// TODO Auto-generated method stub
		msDao.addMessage(message);
	}

	@Override
	public List<Message> getMessageByClient(Client client) {
		// TODO Auto-generated method stub
		return msDao.getMessageByClient(client);
	}

	@Override
	public List<Message> getMessageByClientAndStatus(Client client) {
		// TODO Auto-generated method stub
		return msDao.getMessageByClientAndStatus(client);
	}

	@Override
	public Message getMessageById(int id) {
		// TODO Auto-generated method stub
		return msDao.getMessageById(id);
	}

	@Override
	public void UpdateMessage(Message message) {
		// TODO Auto-generated method stub
		msDao.UpdateMessage(message);
	}
	
	

}
