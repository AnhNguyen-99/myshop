package com.myshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myshop.entity.Account;
import com.myshop.entity.Producer;
import com.myshop.service.ProducerService;

@Controller
@RequestMapping(value = "manages/producer")
public class ControllerProducer {

	@Autowired
	private ProducerService producerService;
	
	@RequestMapping(value = "/list")
	public String viewList(Model model) {
		model.addAttribute("listProducer", producerService.getAll());
		return "manages/producer_list";
	}
	
	@RequestMapping(value = "/create")
	public String viewCreate(Model model) {
		model.addAttribute("producer", new Producer());
		return "manages/producer_form";
	}
	
	@RequestMapping(value = "/save")
	public String viewSave(@ModelAttribute("producer") Producer producer, HttpSession session) {
		Account account = (Account) session.getAttribute("myLogin");
		producer.setAccount(account);
		boolean bl = false;
		if(producer.getProducerId() != 0)
			bl = producerService.update(producer);
		else
			bl = producerService.save(producer);
		if(bl)
			return "manages/producer_list";
		else
			return "manages/producer_form";
	}
	
	// Edit
	@RequestMapping(value = "/edit/{producerId}")
	public String viewEdit(@PathVariable("producerId") int producerId, Model model) {
		model.addAttribute("category", producerService.findById(producerId));
		return "manages/category_form";
	}
	
	// Delete
	@RequestMapping(value = "/delete/{producerId}")
	public String viewDelete(@PathVariable("producerId") int producerId, Model model) {
		Producer producer = producerService.findById(producerId);
		boolean bl = producerService.delete(producer);
		if(bl)
			return "manages/category_list";
		else
			return "manages/category_list";
	}
	
}
