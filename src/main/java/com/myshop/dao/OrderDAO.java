package com.myshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.entity.Orders;

@Repository(value = "orderDAO")
@Transactional(rollbackFor = Exception.class)
public class OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(final Orders orders) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(orders);
	}
	
	public Orders findById(int orderId) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Orders.class, orderId);
	}
	
	public List<Orders> getAll(){
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Orders ORDER BY orderDate DESC", Orders.class).getResultList();
	}
	
	public List<Orders> getByAccountId(int accountId){
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Orders WHERE accountId =:accountId ORDER BY orderDate DESC", Orders.class).setParameter("accountId", accountId).getResultList();
	}
	
}
