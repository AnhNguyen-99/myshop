package com.myshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myshop.entity.Account;
import com.myshop.entity.AccountRole;
import com.myshop.service.AccountService;

@Controller
public class HomeController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String viewInitLogin(Model model) {
		model.addAttribute("account", new Account());
		return "manages/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String viewLogin(@ModelAttribute("account") Account account, Model model, HttpSession session) {
		Account acc = accountService.login(account.getAccountName(), account.getAccountPass());
		if(acc == null) {
			model.addAttribute("account", new Account());
			session.setAttribute("myLogin", null);
		}
		session.setAttribute("myLogin", acc);
		return "redirect:homeLogin";
	}
	
	@RequestMapping(value = "/homeLogin")
	public String viewHomeLogin(Model model, HttpSession session) {
		Account account = (Account) session.getAttribute("myLogin");
		if(account == null) {
			return "redirect:login";
		}else {
			AccountRole accountRole = accountService.login_role(account.getAccountId());
			if(accountRole.getRole().getRoleId() == 1)
				return "redirect:manages/home";
			else
				return "redirect:home";
		}
	}
	
	@RequestMapping(value = "/logout")
	public String viewLogout(Model model, HttpSession session) {
		session.setAttribute("myLogin", null);
		return "redirect:home";
	}
	
}
