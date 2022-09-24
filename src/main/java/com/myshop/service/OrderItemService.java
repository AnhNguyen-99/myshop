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
	private OrderItemDAO OrderItemDAO;
	
	public void save(final OrderItem OrderItem) {
		OrderItemDAO.save(OrderItem);
	}
	
	public List<OrderItem> getByOrderId(Integer orderId){
		return OrderItemDAO.getByOrderId(orderId);
	}
}
