package com.myshop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myshop.entity.Account;
import com.myshop.entity.Cart;
import com.myshop.entity.Order;
import com.myshop.entity.Product;
import com.myshop.entity.Role;
import com.myshop.service.AccountService;
import com.myshop.service.CategoryService;
import com.myshop.service.NewsService;
import com.myshop.service.ProducerService;
import com.myshop.service.ProductService;

@Controller
public class ControllerPage {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProducerService producerService;
	
	@Autowired
	private NewsService newsService;
	
	// Login
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String viewInitLogin(Model model) {
		model.addAttribute("account", new Account());
		return "page/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String viewLogin(@ModelAttribute("account") Account account, Model model, HttpSession session) {
		Account acc = accountService.login(account.getAccountName(), account.getAccountPass());
		if(acc== null) {
			model.addAttribute("account", new Account());
			session.setAttribute("myLogin", null);
		}
		session.setAttribute("myLogin", acc);
		return "redirect:homeLogin";
	}
	
	@RequestMapping(value = "/homeLogin")
	public String viewHomeLogin(Model model, HttpSession session) {
		Account account = (Account) session.getAttribute("myLogin");
		if(account == null) {
			return "redirect:login";
		}else {
			if(account.getRoleId().getRoleId() == 1)
				return "redirect:manages/home";
			else
				return "redirect:home";
		}
	}
	// Trang home admin
	@RequestMapping(value = "/manages/home")
	public String viewHomeManages(Model model) {
		model.addAttribute("listCategory", categoryService.findAll());
		return "manages/index";
	}
	
	// Trang chu
	@RequestMapping(value = "/home")
	public String viewHomePage(Model model, HttpSession session) {
		check_account(session);
		model.addAttribute("listCategory", categoryService.findAll());
		model.addAttribute("listProductSale", productService.getListBySale(8));
        model.addAttribute("listProductPrice", productService.getListByPrice(8));
		return "page/index";
	}
	
	//
	private void shopMyCart(HttpSession session) {
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        double count = 0;
        for (Map.Entry<Integer, Cart> list : cartItems.entrySet()) {
            count += list.getValue().getProduct().getProductPrice() * list.getValue().getQuantity();
        }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", count);
        session.setAttribute("myCartNum", cartItems.size());
    }
	
	// Táº¡o tÃ i khoáº£n
    @RequestMapping(value = "/regist", method = RequestMethod.GET)
    public String viewInitRegist(Model model){
        model.addAttribute("account", new Account());
        return "page/regist";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String viewRegist(@ModelAttribute()Account account, Model model, HttpSession session){
        Role role = new Role();
        role.setRoleId(2);
        account.setRoleId(role);
        boolean bl = accountService.create(account);
        if(bl){
            session.setAttribute("myLogin", account);
            return "redirect:home.htm";
        }else{
            model.addAttribute("status", "Táº¡o tÃ i khoáº£n khÃ´ng thÃ nh cÃ´ng !!!");
            return "page/regist";
        }
    }
    
	// Logout 
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String viewLogout(@ModelAttribute("Account")Account account, Model model, HttpSession session){
        session.setAttribute("myLogin", null);
        return "redirect:home";
    }
    
    //Xem chi tiáº¿t sáº£n pháº©m
    @RequestMapping(value = "/detailProduct/{productId}", method = RequestMethod.GET)
    public String viewDetail(@PathVariable("productId")Integer productId, Model model){
        Product product = productService.findById(productId);
        model.addAttribute("product", product);
        return "page/single-product";
    }
    
    // Shop
    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public String viewShop(Model model, Integer offset, Integer maxResult){
        model.addAttribute("listProduct", productService.getListNav(offset, maxResult));
        model.addAttribute("offset", offset == null ? 0 : offset);
        model.addAttribute("maxResult", maxResult == null ? 6 : maxResult);
        model.addAttribute("count", productService.totalItem());
        model.addAttribute("listCategory", categoryService.findAll());
        model.addAttribute("listProducer", producerService.getAll());
        return "page/category";
    }
    
    // Sáº£n pháº©m theo danh má»¥c
    @RequestMapping(value = "/findByCategoryId/{categoryId}",method = RequestMethod.GET)
    public String viewFind(@PathVariable("categoryId") int categoryId,Integer offset, Integer maxResult ,Model model){
//        model.addAttribute("listProduct", productService.getListByCategoryAndLimit(categoryId, offset, maxResult));
//        model.addAttribute("offset", offset == null ? 0 : offset);
//        model.addAttribute("maxResult", maxResult == null ? 6 : maxResult);
//        model.addAttribute("count", productService.totalProductByCategoryId(categoryId));
    	model.addAttribute("listProduct", productService.getListByCategoryId(categoryId));
        model.addAttribute("listCategory", categoryService.findAll());
        model.addAttribute("listProducer", producerService.getAll());
        return "page/category";
    }
    
    // List danh sÃƒÂ¡ch sÃ¡ÂºÂ£n phÃ¡ÂºÂ©m theo producerId
//    @RequestMapping(value = "/producer/{producerId}", method = RequestMethod.GET)
//    public String viewProducer(@PathVariable("producerId") int producerId, Model model, Integer offset, Integer maxResult) {
//        model.addAttribute("listProduct", productService.getListByProducerAndLimit(producerId, offset, maxResult));
//        model.addAttribute("offset", offset == null ? 0 : offset);
//        model.addAttribute("maxResult", maxResult == null ? 6 : maxResult);
//        model.addAttribute("count", productService.totalProductByProducerId(producerId));
//        model.addAttribute("listCategory", categoryService.getAll());
//        model.addAttribute("listProducer", producerService.getAll());
//        return "page/category";
//    }
//    
    // TÃ¬m kiáº¿m
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public String viewSeach(@RequestParam("query")String productName,Model model){
        List<Product> list = productService.getListByProductName(productName);
        if(list != null)
            model.addAttribute("listProduct", list);
        else{
            String status = "KhÃ´ng cÃ³ sáº£n pháº©m mÃ  báº¡n muá»‘n tÃ¬m!!!";
            System.out.println(status);
            model.addAttribute("status", status);
        }
        return "page/search-product";
    }

    
    // Checkout
    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String viewCheckout(Model model, HttpSession session){
        model.addAttribute("listCategory", categoryService.findAll());
        shopMyCart(session);
        Account account = (Account) session.getAttribute("myLogin");
        if(account == null){
            return "redirect:login";
        }else{
            Order order = new Order();
            order.setAccountId(account);
            order.setOrderName(account.getAccountName());
            order.setAddress(account.getAddress());
            order.setMobile(account.getMoblie());
            order.setMail(account.getAccountMail());
            model.addAttribute("order", order);
            return "page/checkout";
        }
    }
    
        
    // detail orderitem
    @RequestMapping(value = "/detailOrder/{orderId}", method = RequestMethod.GET)
    public String viewDetailOrder(@PathVariable("orderId") Integer orderId, Model model, HttpSession session){
//        model.addAttribute("listOrderItem", orderItemService.getListByOrderId(orderId));
        return "page/detaiOrderItem";
    }
    
    // contact 
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String viewContact(Model model){
        return "page/contact";
    }
    
    // Blog
    @RequestMapping(value = "/blog", method = RequestMethod.GET)
    public String viewBlog(Model model){
        model.addAttribute("listNews", newsService.getAll());
        return "page/blog";
    }
    // Chi tiết về tin tức
    @RequestMapping(value = "/detailBlog/{newsId}", method = RequestMethod.GET)
    public String viewDetail(@PathVariable("newsId")Integer newsId, Model model, HttpSession session){
    	model.addAttribute("news", newsService.findById(newsId));
        return "page/single-blog";
    }
    
    // Checkaccount
    public void check_account(HttpSession session){
        Account acc = (Account) session.getAttribute("myLogin");
        
        if(acc == null){
            session.setAttribute("thuoctinh1", "login");
            session.setAttribute("thuoctinh2", "regist");
        }else{
            session.setAttribute("thuoctinh1", "logout");
            session.setAttribute("thuoctinh2", "inforaccount");
        }
    }
    
}
