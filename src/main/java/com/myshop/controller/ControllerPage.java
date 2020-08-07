package com.myshop.controller;

import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myshop.entity.Account;
import com.myshop.entity.Feedback;
import com.myshop.entity.Orders;
import com.myshop.entity.Product;
import com.myshop.service.CategoryService;
import com.myshop.service.FeedBackService;
import com.myshop.service.ProducerService;
import com.myshop.service.ProductService;

@Controller
public class ControllerPage {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProducerService producerSerive;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private FeedBackService feedBackService;
	
	@RequestMapping(value = "/home")
	public String viewHomePage(Model model) {
		model.addAttribute("listProduct", productService.getAll());
		model.addAttribute("listCategory", categoryService.getAll());
		model.addAttribute("listProducer", producerSerive.getAll());
		return "page/index";
	}
	
	@RequestMapping(value = "/manages/home")
	public String viewHomeManages(Model model) {
		return "manages/index";
	}
	

	// Product Detail
	@RequestMapping(value = "/product-detail/{productId}")
	public String viewProductDetail(@PathVariable("productId") int productId, Model model) {
		model.addAttribute("product", productService.findById(productId));
		return "page/product_detail";
	}
	
	// Contact
	@RequestMapping(value = "/contact")
	public String viewContact(Model model) {
		model.addAttribute("feedBack", new Feedback());
		return "page/contact";
	}
	
	// Save feedback
	@RequestMapping(value = "/save_feedback")
	public String viewFeedBack(@ModelAttribute("feedBack") Feedback feedBack, HttpSession session) {
		boolean bl = feedBackService.save(feedBack);
		if(bl)
			return "redirect:home";
		else
			return "page/contact";
	}
	
	// Search
	@RequestMapping(value = "/search")
	public String viewSearch(@RequestParam("query") String query, Model model) {
		List<Product> listProduct = productService.findByName(query);
		model.addAttribute("listProduct", listProduct);
		return "page/shop";
	}
	
	// Cart
	@RequestMapping(value = "/cart")
	public String viewCart() {
		return "page/cart";
	}
	
	// Checkout
	@RequestMapping(value = "/checkout")
	public String viewCheckout(Model model, HttpSession session) {
		Account account = (Account) session.getAttribute("myLogin");
		if(account != null) {
			Orders order = new Orders();
	        order.setAccount(account);
	        order.setOrderName(account.getAccountName());
	        order.setAddress(account.getAddress());
	        order.setPhone(account.getMobile());
	        order.setMail(account.getMail());
	        model.addAttribute("order", order);
			return "page/checkout";
		}else {
			return "redirect:login";
		}
		
	}
	
	// About
	@RequestMapping(value = "/about")
	public String viewAbout() {
		return "page/about";
	}
	
	// Shop
	@RequestMapping(value = "/shop")
	public String viewShop() {
		return "page/shop";
	}
	
//	// Send mail
//	@RequestMapping(value = "/intsendMail")
//	public String viewSendMail() {
//		return "page/sendMail";
//	}
//	
//	@RequestMapping(value = "/sendMail")
//	public String viewSendMail(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("subject") String subject, @RequestParam("content") String content) {
//		// print infor mail
//		System.out.println("Name: " + name);
//		System.out.println("Email: " + email);
//		System.out.println("Subject: " + subject);
//		System.out.println("Content: " + content);
//		//Send mail
//		
//		return "";
//	}
		
}
