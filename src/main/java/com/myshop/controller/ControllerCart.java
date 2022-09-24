package com.myshop.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myshop.entity.Account;
import com.myshop.entity.Cart;
import com.myshop.entity.OrderItem;
import com.myshop.entity.Orders;
import com.myshop.entity.Product;
import com.myshop.entity.Statusorder;
import com.myshop.service.OrderItemService;
import com.myshop.service.OrderService;
import com.myshop.service.ProductService;

@Controller
@RequestMapping(value = "cart")
public class ControllerCart {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderItemService OrderItemService;
	
	@RequestMapping(value = "/add/{productId}")
    public String viewAdd(@PathVariable("productId")int productId, Model model, HttpSession session){
		HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        Product product = productService.findById(productId);
        if (product != null) {
            if (cartItems.containsKey(productId)) {
                Cart item = cartItems.get(productId);
                item.setProduct(product);
                item.setQuantity(item.getQuantity() + 1);
                cartItems.put(productId, item);
            } else {
                Cart item = new Cart();
                item.setProduct(product);
                item.setQuantity(1);
                cartItems.put(productId, item);
            }
        }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        session.setAttribute("myCartNum", cartItems.size());
        return "page/cart";
	}
	
	private Float totalPrice(HashMap<Integer, Cart> cartItems) {
        int count = 0;
        for (Map.Entry<Integer, Cart> list : cartItems.entrySet()) {
        	if(list.getValue().getProduct().getProductSale() == 0)
        		count += list.getValue().getProduct().getProductPrice() * list.getValue().getQuantity();
            else
            	count += (list.getValue().getProduct().getProductPrice() - (list.getValue().getProduct().getProductSale() * list.getValue().getProduct().getProductPrice())/100 ) * list.getValue().getQuantity();
        }
        return (float) count;
    }
	
	@RequestMapping(value = "/remove/{productId}")
	public String viewRemove(@PathVariable("productId")Integer productId, HttpSession session){
	    HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
	    if (cartItems == null) {
	        cartItems = new HashMap<>();
	    }
	    if (cartItems.containsKey(productId)) {
	        cartItems.remove(productId);
	    }
	    session.setAttribute("myCartItems", cartItems);
	    session.setAttribute("myCartTotal", totalPrice(cartItems));
	    session.setAttribute("myCartNum", cartItems.size());
	    return "page/cart";
	}
	
	@RequestMapping(value = "/viewcart")
    public String viewCart(Model model, HttpSession session){
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if(cartItems.size() == 0){
        	model.addAttribute("listProduct", productService.getAll());
            return "page/index";
        }else{
            session.setAttribute("myCartItems", cartItems);
            session.setAttribute("myCartTotal", totalPrice(cartItems));
            session.setAttribute("myCartNum", cartItems.size());
            return "page/cart";
        }
    }
	
	@RequestMapping(value = "/checkout")
	public String viewCheckout(@ModelAttribute("order") Orders orders, Model model, HttpSession session) {
		HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
		if(cartItems == null)
			cartItems = new HashMap<>();
		Account account = (Account) session.getAttribute("myLogin");
		Calendar calendar = Calendar.getInstance();
		orders.setAccount(account);
		orders.setOrderDate(calendar.getTime());
		Statusorder statusorder = new Statusorder(1);
		orders.setStatusorder(statusorder);
		orders.setTotalPrice(totalPrice(cartItems));
		orderService.save(orders);
		OrderItem OrderItem = new OrderItem();
        OrderItem.setOrders(orders);
		for (Map.Entry<Integer, Cart> entry : cartItems.entrySet()) {
            OrderItem.setProduct(entry.getValue().getProduct());
            OrderItem.setPrice(entry.getValue().getProduct().getProductPrice() * entry.getValue().getQuantity());
            OrderItem.setQuantity(entry.getValue().getQuantity());
            OrderItemService.save(OrderItem);
        }
        cartItems = new HashMap<>();
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", 0);
        session.setAttribute("myCartNum", 0);
		return "page/order_complete";
	}
	
	@RequestMapping(value = "/checkout_complete")
	public String view() {
		return "page/order_complete";
	}
	
}
