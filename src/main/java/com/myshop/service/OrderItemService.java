package com.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.dao.OrderItemDAO;
import com.myshop.entity.Orderitem;

@Service
@Transactional
public class OrderItemService {

	@Autowired
	private OrderItemDAO orderItemDAO;
	
	public void save(final Orderitem orderitem) {
		orderItemDAO.save(orderitem);
	}
	
	public List<Orderitem> getByOrderId(Integer orderId){
		return orderItemDAO.getByOrderId(orderId);
	}
}
