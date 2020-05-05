package com.myshop.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestMethod;

import com.myshop.entity.Category;
import com.myshop.entity.Producer;
import com.myshop.entity.Product;
import com.myshop.service.CategoryService;
import com.myshop.service.ProducerService;
import com.myshop.service.ProductService;

@Controller
@RequestMapping(value = "/manages/product")
public class ControllerProduct {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProducerService producerService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String viewListProduct(Model model, Integer offset, Integer maxResult) {
        List<Product> list = productService.getListNav(offset, maxResult);
        model.addAttribute("listProduct", list);
        model.addAttribute("offset", offset == null ? 0 : offset);
        model.addAttribute("maxResult", maxResult == null ? 3 : maxResult);
        model.addAttribute("count", productService.totalItem());
		model.addAttribute("listProduct", productService.getAll());
		return "manages/product_list";
	}

	// add product
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String viewAddProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		System.out.println(product);
		model.addAttribute("listCategory", categoryService.findAll());
		model.addAttribute("listProducer", producerService.getAll());
		return "manages/product_form";
	}

	// Upload
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String viewSaveProduct(@ModelAttribute("product") Product product, Model model, HttpServletRequest request) {
		String path = request.getRealPath("/resorces/page/img/product");
		System.out.println(path);
        path = path.substring(0, path.indexOf(".metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps"));
        path = path + "MyShop\\src\\main\\webapp\\resources\\page\\img\\product";
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
					} else if (name.equals("categoryId.categoryId")) {
						Category c = new Category(Integer.parseInt(value));
						product.setCategoryId(c);
					} else if (name.equals("producerId.producerId")) {
						Producer producer = new Producer(Integer.parseInt(value));
						product.setProducerId(producer);
					} else if (name.equals("productName")) {
						product.setProductName(new String(value.getBytes("iso-8859-1"), "UTF-8"));
					} else if (name.equals("productPrice")) {
						product.setProductPrice(Double.parseDouble(value));
					} else if (name.equals("productSale")) {
						product.setProductSale(Integer.parseInt(value));
					} else if (name.equals("unit")) {
						product.setUnit(new String(value.getBytes("iso-8859-1"), "UTF-8"));
					} else if (name.equals("shortdescription")) {
						product.setShortdescription(new String(value.getBytes("iso-8859-1"), "UTF-8"));
					} else if (name.equals("description")) {
						product.setDescription(new String(value.getBytes("iso-8859-1"), "UTF-8"));
					}
				} else {
					if (item.getFieldName().equals("productImage")) {
						item.write(new File(path + "/" + item.getName()));
						product.setProductImage(item.getName());
					} else if (item.getFieldName().equals("productImage2")) {
						item.write(new File(path + "/" + item.getName()));
						product.setProductImage2(item.getName());
					} else if (item.getFieldName().equals("productImage3")) {
						item.write(new File(path + "/" + item.getName()));
						product.setProductImage3(item.getName());
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
		System.out.println(product);
		boolean bl;
		if (product.getProductId() == null)
			bl = productService.create(product);
		else {
			bl = productService.update(product);
		}
		if (bl) {
			return "redirect:list";
		} else {
			return "manages/product_form";
		}
	}

	@RequestMapping(value = "/edit/{productId}", method = RequestMethod.GET)
	public String viewEditProduct(@PathVariable("productId") int productId, Model model) {
		Product product = productService.findById(productId);
		model.addAttribute("product", product);
		model.addAttribute("listCategory", categoryService.findAll());
		return "manages/product_form";
	}

	@RequestMapping(value = "/remove/{productId}", method = RequestMethod.GET)
	public String viewRemoveProduct(@PathVariable("productId") int productId, Model model, Integer offset,
			Integer maxResult) {
		Product product = productService.findById(productId);
		if (product != null) {
			productService.delete(product);
		}
//		model.addAttribute("listProduct", productService.getListNav(offset, maxResult));
//		model.addAttribute("offset", offset == null ? 0 : offset);
//		model.addAttribute("maxResult", maxResult == null ? 6 : maxResult);
//		model.addAttribute("count", productService.totalItem());
		return "manages/product_list";
	}


}
