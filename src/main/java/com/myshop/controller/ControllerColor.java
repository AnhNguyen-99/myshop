package com.myshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myshop.entity.Color;
import com.myshop.service.ColorService;

@Controller
@RequestMapping(value = "manages/color")
public class ControllerColor {
	
	@Autowired
	private ColorService colorService;
	
	@RequestMapping(value = "/list")
	public String viewList(Model model) {
		model.addAttribute("listColor", colorService.getAll());
		return "manages/color_list";
	}
	
	@RequestMapping(value = "/create")
	public String viewCreate(Model model) {
		model.addAttribute("color", new Color());
		return "manages/color_form";
	}

	@RequestMapping(value = "/save")
	public String viewSave(@ModelAttribute("color") Color color, Model model) {
		boolean bl = colorService.save(color);
		if(bl)
			return "manages/color_list";
		else
			return "manages/color_form";
	}
	
	@RequestMapping(value = "/delete/{colorId}")
	public String viewDelete(@PathVariable("colorId") int colorId) {
		Color color = colorService.findById(colorId);
		boolean bl = colorService.delete(color);
		if(bl)
			return "manages/color_list";
		else
			return "manages/color_list";
	}
}
