package com.myshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.entity.Category;

@Repository(value = "categoryDAO")
@Transactional(rollbackFor = Exception.class)
public class CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean save(final Category category) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(category);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public boolean update(final Category category) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.merge(category);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public boolean delete(final Category category) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.delete(category);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public List<Category> getAll(){
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Category", Category.class).getResultList();
	}
	
	public Category findById(int categoryId) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Category.class, categoryId);
	}
	
}
