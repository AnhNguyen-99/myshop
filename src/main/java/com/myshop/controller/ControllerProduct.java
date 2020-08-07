package com.myshop.controller;

import java.util.Iterator;

import javax.servlet.ServletContext;

import java.io.File;
import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myshop.entity.Account;
import com.myshop.entity.Category;
import com.myshop.entity.Producer;
//import com.myshop.entity.Account;
//import com.myshop.entity.Category;
//import com.myshop.entity.Producer;
import com.myshop.entity.Product;
import com.myshop.service.CategoryService;
import com.myshop.service.ProducerService;
import com.myshop.service.ProductService;

@Controller
@RequestMapping(value = "manages/product")
public class ControllerProduct {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProducerService producerService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ServletContext context;
	
	@RequestMapping(value = "/list")
	public String viewList(Model model) {
		model.addAttribute("listProduct", productService.getAll());
		return "manages/product_list";
	}
	
	@RequestMapping(value = "/create")
	public String viewCreate(Model model, HttpSession session) {
		Account account = (Account) session.getAttribute("myLogin");
		Product product = new Product();
		product.setAccount(account);
		model.addAttribute("product", product);
		System.out.println(product);
		model.addAttribute("listCategory", categoryService.getAll());
		model.addAttribute("listProducer", producerService.getAll());
		return "manages/product_form";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String viewSaveProduct(@ModelAttribute("product") Product product, Model model, HttpServletRequest request, HttpSession session) {
		System.out.println(product);
		String path = request.getRealPath("/resources/page/images/product");
		System.out.println(path);
		path = path.substring(0, path.indexOf(".metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps"));
        path = path + "MyShop\\src\\main\\webapp\\resources\\page\\images\\product";
        System.out.println(path);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				if (item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString();
					if (name.equals("productId")) {
						if (value != null && value.length() > 0)
							product.setProductId(Integer.parseInt(value));
					} else if (name.equals("category.categoryId")) {
						Category c = new Category(Integer.parseInt(value));
						product.setCategory(c);
					} else if (name.equals("producer.producerId")) {
						Producer producer = new Producer(Integer.parseInt(value));
						product.setProducer(producer);
					} else if (name.equals("producerName")) {
						product.setProducerName(new String(value.getBytes("iso-8859-1"), "UTF-8"));
					} else if (name.equals("productPrice")) {
						product.setProductPrice(Float.parseFloat(value));
					} else if (name.equals("productSale")) {
						product.setProductSale(Integer.parseInt(value));
					} else if (name.equals("content")) {
						product.setContent(new String(value.getBytes("iso-8859-1"), "UTF-8"));
					} else if (name.equals("productDescription")) {
						product.setProductDescription(new String(value.getBytes("iso-8859-1"), "UTF-8"));
					}
				} else {
					if (item.getFieldName().equals("productImage")) {
						item.write(new File(path + "/" + item.getName()));
						product.setProductImage(item.getName());
					}
				}
			}
		} catch (FileUploadException ex) {
			Logger.getLogger(ControllerProduct.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedEncodingException ex) {
			Logger.getLogger(ControllerProduct.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ParseException ex) {
			Logger.getLogger(ControllerProduct.class.getName()).log(Level.SEVERE, null, ex);
		} catch (Exception ex) {
			Logger.getLogger(ControllerProduct.class.getName()).log(Level.SEVERE, null, ex);
		}
		boolean bl = false;
		Account account = (Account) session.getAttribute("myLogin");
		product.setAccount(account);
		System.out.println(product);
		if (product.getProductId() == null)
			bl = productService.save(product);
		else {
			bl = productService.update(product);
		}
		if (bl) {
			return "redirect:list";
		} else {
			return "manages/product_form";
		}
	}
	
	
//	@RequestMapping(value = "save", method = RequestMethod.POST)
//	public String viewSave(@ModelAttribute("product") Product product, Model model, MultipartHttpServletRequest request) {
//		String path = context.getRealPath("/resorces/page/images/product");
//		Iterator<String> listNames = request.getFileNames();
//		MultipartFile mpf = request.getFile(listNames.next());
//		
//		File file = new File(path + mpf.getOriginalFilename());
//		try {
//			mpf.transferTo(file);
//		} catch (IllegalStateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Account account = new Account(2);
//		Category category = new Category(6);
//		Producer producer = new Producer(1);
//		product.setAccount(account);
//		product.setCategory(category);
//		product.setProducer(producer);
//		boolean bl = productService.save(product);
//		if(bl) 
//			return "redirect:list";
//		else
//			return "manages/product_form";
//	}
	
	@RequestMapping(value = "/edit/{productId}")
	public String viewEditProduct(@PathVariable("productId") int productId, Model model) {
		Product product = productService.findById(productId);
		model.addAttribute("product", product);
		model.addAttribute("listCategory", categoryService.getAll());
		model.addAttribute("listProducer", producerService.getAll());
		return "manages/product_form";
	}
	
	@RequestMapping(value = "delete/{productId}")
	public String viewDelete(@PathVariable("productId") int productId, Model model) {
		Product product = productService.findById(productId);
		boolean bl = productService.delete(product);
		if(bl)
			return "manages/product_list";
		else
			return "manages/product_list";
	}
	
}
