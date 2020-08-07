package com.myshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.entity.Account;
import com.myshop.entity.AccountRole;

@Repository(value="accountDAO")
@Transactional(rollbackFor = Exception.class)
public class AccountDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Account login(String userName, String pass) {
		Session session = this.sessionFactory.getCurrentSession();
		Account account = (Account) session.createQuery("FROM Account WHERE accountName =:accountName AND accountPass =:accountPass").setParameter("accountName", userName).setParameter("accountPass", pass).uniqueResult();
		return account;
	}
	
	// role
	public AccountRole login_role(int accountId) {
		Session session = this.sessionFactory.getCurrentSession();
		AccountRole accountRole = (AccountRole) session.createQuery("FROM AccountRole WHERE accountId =:accountId").setParameter("accountId", accountId).uniqueResult();
		return accountRole;
	}
	
	public List<AccountRole> getListAccountByRoleId(int roleId){
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM AccountRole WHERE roleId =:roleId", AccountRole.class).setParameter("roleId", roleId).getResultList();
	}
	
	public boolean save(final Account account) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(account);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public Account findByName(String accountName) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Account WHERE accountName =:accountName", Account.class).setParameter("accountName", accountName).uniqueResult();
	}
	
	public boolean update(final Account account) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.merge(account);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
