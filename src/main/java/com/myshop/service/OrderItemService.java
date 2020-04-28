package com.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.dao.OrderItemDAO;
import com.myshop.entity.OrderItem;

@Service
@Transactional
public class OrderItemService {

	@Autowired
	private OrderItemDAO orderItemDAO;
	
	public void create(final OrderItem orderItem) {
		orderItemDAO.create(orderItem);
	}
    
    public void update(final OrderItem orderItem) {
    	orderItemDAO.update(orderItem);
    }
    
    public void delete(final OrderItem orderItem) {
    	orderItemDAO.delete(orderItem);
    }
    
    public OrderItem findById(final int orderItemId) {
    	return orderItemDAO.findById(orderItemId);
    }
    
    public List<OrderItem> getListByOrderId(Integer orderId){
    	return orderItemDAO.getListByOrderId(orderId);
    }
   
}
