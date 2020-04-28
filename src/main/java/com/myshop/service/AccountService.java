package com.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.dao.AccountDAO;
import com.myshop.entity.Account;

@Service
@Transactional
public class AccountService {

	@Autowired
	private AccountDAO accountDAO;
	
	public Account login(String userName, String pass) {
		return accountDAO.login(userName, pass);
	}
	
	public List<Account> getAll(){
		return accountDAO.getAll();
	}
	
	public boolean create(Account obj) {
		return accountDAO.create(obj);
	}
	
	public boolean update(Account obj) {
		return accountDAO.update(obj);
	}
	
	public boolean delete(Account obj) {
		return accountDAO.delete(obj);
	}
}
