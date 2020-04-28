package com.myshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myshop.entity.Account;
import com.myshop.entity.Role;
import com.myshop.service.AccountService;

@Controller
@RequestMapping(value = "manages/account")
public class ControllerAccount {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "/list")
	public String viewListAccount(Model model) {
		model.addAttribute("listAccount", accountService.getAll());
		return "manages/account_list";
	}
	

	@RequestMapping(value = "/add")
	public String viewAddAccount(Model model) {
		model.addAttribute("account", new Account());
		return "manages/account_form";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String viewSave(@ModelAttribute("account") Account account, Model model) {
		Role role = new Role();
        role.setRoleId(1);
        account.setRoleId(role);
        boolean bl = accountService.create(account);
        if(bl) {
        	return "redirect:list";
        }else
        	return "manages/account_form";
	}
}
