package com.myshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.entity.OrderItem;

@Repository(value = "OrderItemDAO")
@Transactional(rollbackFor = Exception.class)
public class OrderItemDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(final OrderItem OrderItem) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(OrderItem);
	}
	
	public List<OrderItem> getByOrderId(Integer orderId){
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM OrderItem WHERE orderId =:orderId", OrderItem.class).setParameter("orderId", orderId).getResultList();
	}
	
}
