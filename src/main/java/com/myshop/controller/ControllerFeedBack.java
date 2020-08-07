package com.myshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myshop.service.FeedBackService;

@Controller
@RequestMapping(value = "manages/feedback")
public class ControllerFeedBack {

	@Autowired
	private FeedBackService feedBackService;
	
	@RequestMapping(value = "/list")
	public String viewList(Model model) {
		model.addAttribute("listFeedBack", feedBackService.getAll());
		return "manages/feedback_list";
	}
	
}
