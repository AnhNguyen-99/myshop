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

	// save
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

	//update
	public void update(final Category category) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(category);
	}
	
	// delete
	public void delete(final Category category) {
		Session session = this.sessionFactory.getCurrentSession();
		session.remove(category);
	}
	
	// getall
	public List<Category> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Category", Category.class).getResultList();
	}
	
	public Category findById(final int categoryId) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Category.class, categoryId);
	}
}
