package com.myshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.entity.Product;

@Repository(value = "productDAO")
@Transactional(rollbackFor = Exception.class)
public class ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean save(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(product);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public boolean update(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.merge(product);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public boolean delete(final Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.delete(product);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public List<Product> getAll(){
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Product", Product.class).getResultList();
	}
	
	public Product findById(int productId) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Product.class, productId);
	}

	public List<Product> findByName(String producerName){
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Product WHERE producerName LIKE :producerName", Product.class).setParameter("producerName", producerName).getResultList();
	}
}
