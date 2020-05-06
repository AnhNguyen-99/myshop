package com.myshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.entity.Order;

@Repository(value = "orderDAO")
@Transactional
public class OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void create(final Order order) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(order);
	}
    
    public void update(Order order) {
    	Session session = this.sessionFactory.getCurrentSession();
		session.merge(order);
    }
    
    public void delete(Order order) {
    	Session session = this.sessionFactory.getCurrentSession();
		session.delete(order);
    }
    
    public Order findById(Integer orderId) {
    	Session session = this.sessionFactory.getCurrentSession();
    	return session.get(Order.class , orderId);
    }
    
    public List<Order> getAll(){
    	Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Order", Order.class).getResultList();
    }
    
    public List<Order> getOrderByAccountId(int accountId){
    	Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Order WHER accountId =:accountId", Order.class).setParameter("accountId", accountId).getResultList();
    }
        
    public boolean confirmOrder(Integer orderId) {
    	Session session = this.sessionFactory.getCurrentSession();
    	try {
			 session.createQuery("UPDATE Orders SET orderStatus = true WHERE orderId =:orderId").setParameter("orderId", orderId).executeUpdate();
			 return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return false;
    }
    
    public int totalItem() {
    	Session session = this.sessionFactory.getCurrentSession();
		int size = session.createQuery("FROM Order", Order.class).list().size();
		return size;
    }
    
    public List<Order> getListNav(Integer offset, Integer maxResult){
    	Session session = this.sessionFactory.getCurrentSession();
    	return session.createQuery("FROM Order", Order.class).setFirstResult(offset == null?0:offset).setMaxResults(maxResult == null?6:maxResult).getResultList();
    }
}
