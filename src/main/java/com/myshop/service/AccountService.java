package com.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.dao.AccountDAO;
import com.myshop.entity.Account;
import com.myshop.entity.AccountRole;

@Service
@Transactional
public class AccountService {

	@Autowired
	private AccountDAO accountDAO;
	
	public Account login(String accountName, String accountPass) {
		return accountDAO.login(accountName, accountPass);
	}
	
	public AccountRole login_role(int accountId) {
		return accountDAO.login_role(accountId);
	}
	
	public List<AccountRole> getListAccountByRoleId(int roleId){
		return accountDAO.getListAccountByRoleId(roleId);
	}
	
	public boolean save(final Account account) {
		return accountDAO.save(account);
	}
	
	public Account findByName(String accountName) {
		return accountDAO.findByName(accountName);
	}
	
	public boolean update(final Account account) {
		return accountDAO.update(account);
	}
}
