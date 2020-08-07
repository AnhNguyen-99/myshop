package com.myshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myshop.entity.Sizes;
import com.myshop.service.SizeService;


@Controller
@RequestMapping(value = "manages/size")
public class ControllerSize {

	@Autowired
	private SizeService sizeService;
	
	@RequestMapping(value = "/list")
	public String viewList(Model model) {
		model.addAttribute("listSize", sizeService.getAll());
		return "manages/size_list";
	}
	
	@RequestMapping(value = "/create")
	public String viewCreate(Model model) {
		model.addAttribute("size", new Sizes());
		return "manages/size_form";
	}

	@RequestMapping(value = "/save")
	public String viewSave(@ModelAttribute("size")Sizes size, Model model) {
		boolean bl = sizeService.save(size);
		if(bl)
			return "manages/size_list";
		else
			return "manages/size_form";
	}
	
	@RequestMapping(value = "/delete/{sizeId}")
	public String viewDelete(@PathVariable("sizeId") int sizeId) {
		Sizes size = sizeService.findById(sizeId);
		boolean bl = sizeService.delete(size);
		if(bl)
			return "manages/size_list";
		else
			return "manages/size_list";
	}
	
}
