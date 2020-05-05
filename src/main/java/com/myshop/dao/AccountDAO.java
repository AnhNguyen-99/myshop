package com.myshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.entity.Account;

@Repository(value = "accountDAO")
@Transactional(rollbackFor = Exception.class)
public class AccountDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Account login(String userName, String pass) {
		Session session = this.sessionFactory.getCurrentSession();
		Account acc = (Account) session.createQuery("FROM Account WHERE accountName =:accountName AND accountPass =:accountPass").setParameter("accountName", userName).setParameter("accountPass", pass).uniqueResult();
		return acc;
	}
	
	public List<Account> getAll(){
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Account", Account.class).getResultList();
	}
	
	public boolean create(Account obj) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(obj);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public boolean update(Account obj) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.merge(obj);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public boolean delete(Account obj) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.delete(obj);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public boolean checkName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Account> list = session.createQuery("FROM Account WHERE UPPER(accountName) LIKE :accountName", Account.class).setParameter("accountName", name.toUpperCase()).getResultList();
			if(list.size() > 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
