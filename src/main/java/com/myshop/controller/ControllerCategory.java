package com.myshop.controller;

//import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myshop.dto.CategoryDTO;
import com.myshop.entity.Account;
import com.myshop.entity.Category;
import com.myshop.service.CategoryService;

@Controller
@RequestMapping(value = "manages/category")
public class ControllerCategory {

	@Autowired
	private CategoryService categoryService;
		
	@RequestMapping(value = "/list")
	public String viewList(Model model) {
		model.addAttribute("listCategory", categoryService.getAll());
		return "manages/category_list";
	}
	
	// create 
	@RequestMapping(value = "/create")
	public String viewCreate(Model model) {
		model.addAttribute("category", new Category());
		return "manages/category_form";
	}
	
	@RequestMapping(value = "/save")
	public String viewSave(@ModelAttribute("category") Category category, HttpSession session) {
		Account account = (Account) session.getAttribute("myLogin");
		category.setAccount(account);
		boolean bl = false;
		if(category.getCategoryId() != 0)
			bl = categoryService.update(category);
		else
			bl = categoryService.save(category);
		if(bl)
			return "manages/category_list";
		else
			return "manages/category_form";
	}
	
	// Edit
	@RequestMapping(value = "/edit/{categoryId}")
	public String viewEdit(@PathVariable("categoryId") int categoryId, Model model) {
		model.addAttribute("category", categoryService.findById(categoryId));
		return "manages/category_form";
	}
	
	// Delete
	@RequestMapping(value = "/delete/{categoryId}")
	public String viewDelete(@PathVariable("categoryId") int categoryId, Model model) {
		Category category = categoryService.findById(categoryId);
		boolean bl = categoryService.delete(category);
		if(bl)
			return "manages/category_list";
		else
			return "manages/category_list";
	}
	
	// Call api
	@RequestMapping(value = "/add")
	public String viewAdd(Model model, HttpSession session) {
		Account account = (Account) session.getAttribute("myLogin");
		CategoryDTO categoryDTO = new CategoryDTO();
//		Calendar calendar = Calendar.getInstance();
		categoryDTO.setAccountId(account.getAccountId());
		categoryDTO.setCategoryStatus(true);
//		categoryDTO.setCreateDate(calendar.getTime());
		model.addAttribute("category", categoryDTO);
		return "manages/category_add";
	}
}
