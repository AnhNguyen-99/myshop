package com.myshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.entity.OrderItem;

@Repository(value = "orderItemDAO")
@Transactional(rollbackFor = Exception.class)
public class OrderItemDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void create(final OrderItem orderItem) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(orderItem);
	}
    
    public void update(final OrderItem orderItem) {
    	Session session = this.sessionFactory.getCurrentSession();
		session.merge(orderItem);
    }
    
    public void delete(final OrderItem orderItem) {
    	Session session = this.sessionFactory.getCurrentSession();
		session.delete(orderItem);
    }
    
    public OrderItem findById(final int orderItemId) {
    	Session session = this.sessionFactory.getCurrentSession();
		return (OrderItem) session.createQuery("FROM OrderItem WHERE orderItemId =:orderItemId").setInteger("orderItemIa", orderItemId);
    }
    
    public List<OrderItem> getListByOrderId(Integer orderId){
    	Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM OrderItem WHERE orderId = :orderId").setParameter("orderId", orderId).list();
    }
   
}
