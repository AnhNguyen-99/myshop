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
	private OrderItemService orderItemService;
	
	@RequestMapping(value = "/list")
	public String viewListOrder(Model model, Integer offset, Integer maxResult) {
		model.addAttribute("listOrder", orderService.getListNav(offset, maxResult));
		model.addAttribute("offset", offset == null ? 0 : offset);
        model.addAttribute("maxResult", maxResult == null ? 6 : maxResult);
        model.addAttribute("count", orderService.totalItem());
		return "manages/order_list";
	}
	
	@RequestMapping(value = "/orderDetail/{orderId}")
    public String viewOrderDetail(@PathVariable("orderId") Integer orderId, Model model){
        model.addAttribute("order", orderService.findById(orderId));
        model.addAttribute("listOrderDetail", orderItemService.getListByOrderId(orderId));
        return "manages/orderItem_detail";
    }
}
