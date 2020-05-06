package com.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.dao.OrderDAO;
import com.myshop.entity.Order;

@Service
@Transactional
public class OrderService {

	@Autowired
	private OrderDAO orderDAO;
	
	public void create(final Order order) {
		orderDAO.create(order);
	}
    
    public void update(Order order) {
    	orderDAO.update(order);
    }
    
    public void delete(Order order) {
    	orderDAO.delete(order);
    }
    
    public Order findById(Integer orderId) {
    	return orderDAO.findById(orderId);
    }
    
    public List<Order> getAll(){
    	return orderDAO.getAll();
    }
    
    public List<Order> getOrderByAccountId(int accountId){
    	return orderDAO.getOrderByAccountId(accountId);
    }
    
    public int totalItem() {
    	return orderDAO.totalItem();
    }
    
    public List<Order> getListNav(Integer offset, Integer maxResult){
    	return orderDAO.getListNav(offset, maxResult);
    }
    
}
