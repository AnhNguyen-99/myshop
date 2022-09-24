package com.myshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myshop.service.OrderItemService;
import com.myshop.service.OrderService;

@Controller
@RequestMapping(value = "manages/order")
public class ControllerOrder {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderItemService OrderItemService;
	
	@RequestMapping(value = "/list")
	public String viewList(Model model) {
		model.addAttribute("listOrder", orderService.getAll());
		return "manages/order_list";
	}
	
	@RequestMapping(value = "/OrderItem/{orderId}")
	public String viewOrderItem(@PathVariable("orderId") int orderId, Model model) {
		model.addAttribute("order", orderService.findById(orderId));
		model.addAttribute("listOrderItem", OrderItemService.getByOrderId(orderId));
		return "manages/OrderItem_list";
	}
	
	
}
