package com.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.dao.OrderDAO;
import com.myshop.entity.Orders;

@Service
@Transactional
public class OrderService {

	@Autowired
	private OrderDAO orderDAO;
	
	public void save(final Orders order) {
		orderDAO.save(order);
	}
	
	public Orders findById(int orderId) {
		return orderDAO.findById(orderId);
	}
	
	public List<Orders> getAll(){
		return orderDAO.getAll();
	}
	
	public List<Orders> getByAccountId(int accountId){
		return orderDAO.getByAccountId(accountId);
	}
}
