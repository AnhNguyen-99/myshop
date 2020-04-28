package com.myshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myshop.entity.Category;
import com.myshop.service.CategoryService;

@Controller
@RequestMapping(value = "manages/category")
public class ControllerCategory {

	@Autowired
	private CategoryService categoryService;
	
	// List Category
	@RequestMapping(value = "/list")
	public String viewListCategory(Model model) {
		model.addAttribute("listCategory", categoryService.findAll());
		return "manages/category_list";
	}
	
	// Create
	@RequestMapping("/add")
	public String viewAddCategory(Model model) {
		model.addAttribute("category", new Category());
		return "manages/category_form";
	}
	
	// Update 
	@RequestMapping(value = "/edit/{categoryId}")
	public String viewEditor(@PathVariable("categoryId") int categoryId, Model model) {
		model.addAttribute("category", categoryService.findById(categoryId));
		return "manages/category_form";
	}
	
	// Save
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String viewSaveCategory(@ModelAttribute("category") Category category, Model model) {
		boolean bl = false;
		if(category.getCategoryId() != 0)
			categoryService.update(category);
		else
			bl = categoryService.save(category);
		if(bl == true)
			model.addAttribute("listCustomer", categoryService.findAll());
		return "manages/category_list";
	}
	
	@RequestMapping(value = "/delete/{categoryId}")
	public String viewDelete(@PathVariable("categoryId")int categoryId, Model model) {
		Category category = categoryService.findById(categoryId);
		if(category	!= null) {
			categoryService.delete(category);
			model.addAttribute("listCategory", categoryService.findAll());
		}
		return "manages/category_list";
	}
	
}
