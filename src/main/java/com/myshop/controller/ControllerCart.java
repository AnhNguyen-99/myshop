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
import org.springframework.web.bind.annotation.RequestMethod;

import com.myshop.entity.Account;
import com.myshop.entity.Cart;
import com.myshop.entity.Order;
import com.myshop.entity.OrderItem;
import com.myshop.entity.Product;
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
	private OrderItemService orderItemService;
	
	@RequestMapping(value = "/add/{productId}", method = RequestMethod.GET)
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
//        System.out.println(totalPrice(cartItems));
        return "page/cart";
	}
	
	private Float totalPrice(HashMap<Integer, Cart> cartItems) {
        int count = 0;
        for (Map.Entry<Integer, Cart> list : cartItems.entrySet()) {
//            if(list.getValue().getProductSize().getProductId().getProductSale() == 0){
                count += list.getValue().getProduct().getProductPrice()* list.getValue().getQuantity();
//            }else{
//                count += (list.getValue().getProductSize().getProductId().getProductPrice() - (list.getValue().getProductSize().getProductId().getProductPrice() * (100 - list.getValue().getProductSize().getProductId().getProductSale())/100) ) * list.getValue().getQuantity();
//            }
        }
        return (float) count;
    }
	
	// Remove
    @RequestMapping(value = "/remove/{productSizeId}", method = RequestMethod.GET)
    public String viewRemove(@PathVariable("productSizeId")Integer productSizeId, HttpSession session){
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        if (cartItems.containsKey(productSizeId)) {
            cartItems.remove(productSizeId);
        }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        session.setAttribute("myCartNum", cartItems.size());
        return "page/cart";
    }
    
    // Checkout
    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public String viewCheckout(@ModelAttribute("order")Order order, Model model, HttpSession session){
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        Account account = (Account) session.getAttribute("myLogin");
        order.setAccount(account);
        Calendar c = Calendar.getInstance();
        order.setOrderDate(c.getTime());
        order.setTotalPrice(totalPrice(cartItems));
        order.setOrderStatus(false);
//        System.out.println(order);
        orderService.create(order);
        System.out.println(order);
        for (Map.Entry<Integer, Cart> entry : cartItems.entrySet()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrders(order);
            orderItem.setProduct(entry.getValue().getProduct());
            orderItem.setOrderItemPrice(entry.getValue().getProduct().getProductPrice() * entry.getValue().getQuantity());
            orderItem.setOrderItemQuantity(entry.getValue().getQuantity());
            orderItem.setOrderItemStatus(true);
            orderItemService.create(orderItem);
        }
        cartItems = new HashMap<>();
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", 0);
        session.setAttribute("myCartNum", 0);
        model.addAttribute("listOrderItem", orderItemService.getListByOrderId(order.getOrderId()));
        return "page/confirmation";
    }
    
    // View cart
    @RequestMapping(value = "/viewcart", method = RequestMethod.GET)
    public String viewCart(Model model, HttpSession session){
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if(cartItems.size() == 0){
            model.addAttribute("listProductSale", productService.getListBySale(8));
            model.addAttribute("listProductPrice", productService.getListByPrice(8));
            return "page/index";
        }else{
            session.setAttribute("myCartItems", cartItems);
            session.setAttribute("myCartTotal", totalPrice(cartItems));
            session.setAttribute("myCartNum", cartItems.size());
            return "page/cart";
        }
    }
}
