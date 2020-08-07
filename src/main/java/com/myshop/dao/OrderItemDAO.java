package com.myshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.entity.Orderitem;

@Repository(value = "orderItemDAO")
@Transactional(rollbackFor = Exception.class)
public class OrderItemDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(final Orderitem orderitem) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(orderitem);
	}
	
	public List<Orderitem> getByOrderId(Integer orderId){
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Orderitem WHERE orderId =:orderId", Orderitem.class).setParameter("orderId", orderId).getResultList();
	}
	
}
