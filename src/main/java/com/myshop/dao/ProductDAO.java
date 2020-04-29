package com.myshop.dao;

import java.util.List;

//import javax.persistence.Query;

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
	
	// Save
	public boolean create(final Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(product);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	// Update
	public boolean update(final Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.merge(product);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	// Delete
	public void delete(final Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(product);
	}
	
	// Find by id
	public Product findById(final int productId) {
		Session session = this.sessionFactory.getCurrentSession();
		return (Product) session.createQuery("FROM Product WHERE productId =:productId").setInteger("productId", productId);
	}
	
	// Getall
	public List<Product> getAll(){
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Product").list();
	}
	
	// List ProductSale
	public List<Product> getListBySale(int limit){
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Product ORDER BY productSale DESC").setMaxResults(limit).list();
	}
	
	// listProductPrice
	public List<Product> getListByPrice(int limit){
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Product ORDER BY productPrice DESC").setMaxResults(limit).list();
	}
	
	public List<Product> getListNav(Integer offset, Integer maxResult){
		Session session = this.sessionFactory.getCurrentSession();
		List<Product> list = session.createQuery("FROM Product ORDER BY createDate DESC").setFirstResult(offset == null?0:offset).setMaxResults(maxResult == null?3:maxResult).list();
//		query.setFirstResult();
//        query.setMaxResults();
//        List<Product> list = query.getResultList();
        return list;
	}
	
	public int totalItem() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Product").list().size();
	}
	
	public List<Product> getListByCategoryAndLimit(Integer categoryId, Integer offset, Integer maxResalt){
		Session session = this.sessionFactory.getCurrentSession();
		List<Product> list = session.createQuery("FROM Product WHERE categoryId =:categoryId").setParameter("categoryId", categoryId).setFirstResult(offset == null?0:offset).setMaxResults(maxResalt == null?6:maxResalt).list();
		return list;
	}
	
	public int totalProductByCategoryId(Integer categoryId) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Product> list = session.createQuery("FROM Product WHERE categoryId =:categoryId").setParameter("categoryId", categoryId).list();
		return list.size();
	}
}
