package com.myshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myshop.entity.Producer;
import com.myshop.service.ProducerService;

@Controller
@RequestMapping("manages/producer")
public class ControllerProducer {

	@Autowired
	private ProducerService producerService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String viewListProducer(Model model) {
		model.addAttribute("listProducer", producerService.getAll());
		return "manages/producer_list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String viewAddProducer(Model model) {
		model.addAttribute("producer", new Producer());
		return "manages/producer_form";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String viewSaveProducer(@ModelAttribute("producer") Producer producer, Model model) {
		boolean bl = false;
		if (producer.getProducerId() == null)
			bl = producerService.create(producer);
		else
			bl = producerService.update(producer);
		if (bl) {
			return "redirect:list";
		} else {
//			model.addAttribute("status", "ThÃªm nhÃ  sáº£n xuáº¥t lá»—i!!!");
			return "manages/producer_form";
		}
	}
	
	@RequestMapping(value = "/edit/{producerId}", method = RequestMethod.GET)
	public String viewEdit(@PathVariable("producerId") int producerId, Model model) {
		model.addAttribute("producer", producerService.findById(producerId));
		return "manages/producer_form";
	}


	@RequestMapping(value = "/remove/{producerId}", method = RequestMethod.GET)
	public String viewRemoveProducer(@PathVariable("producerId") int producerId, Model model) {
		Producer producer = producerService.findById(producerId);
		boolean bl = producerService.delete(producer);
		if (bl) {
			model.addAttribute("listProducer", producerService.getAll());
			model.addAttribute("status", "Xóa thành công!");
			return "manages/producer_list";
		} else {
			model.addAttribute("status", "Xóa không thành công!");
			model.addAttribute("listProducer", producerService.getAll());
			return "manages/producer_list";
		}
	}
}
