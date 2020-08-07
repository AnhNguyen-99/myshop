package com.myshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myshop.entity.Account;
import com.myshop.service.AccountService;
import com.myshop.service.RoleService;

@Controller
@RequestMapping(value = "manages/account")
public class ControllerAccount {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "/list_customer")
	public String viewListCustomer(Model model) {
		model.addAttribute("listCustomer", accountService.getListAccountByRoleId(2));
		return "manages/customer_list";
	}
	
	@RequestMapping(value = "/list_manages")
	public String viewListManages(Model model) {
		model.addAttribute("listManages", accountService.getListAccountByRoleId(1));
		return "manages/manages_list";
	}
	
	// Tạo tài khoản quản lý
	@RequestMapping(value = "/create_manages")
	public String viewCreateManages(Model model) {
		model.addAttribute("listRole", roleService.getAll());
		model.addAttribute("account", new Account());
		return "manages/accountManages_form";
	}
	
	@RequestMapping(value = "/save_manages")
	public String viewSaveManages(@ModelAttribute("account") Account account) {
		boolean bl = accountService.save(account);
		if(bl)
			return "redirect: list_manages";
		else
			return "manages/accountManges_form";
	}
	
	// Reset mật khẩu
	@RequestMapping(value = "/reset_account")
	public String viewResetAccount() {
		return "manages/account_reset";
	}

	@RequestMapping(value = "/reset")
	public String viewReset(@RequestParam("accountName") String accountName) {
		Account account = accountService.findByName(accountName);
		account.setAccountPass("1");
		boolean bl = accountService.update(account);
		if(bl)
			return "redirect: list_manages";
		else
			return "redirect: list_manages";
	}
	
}
