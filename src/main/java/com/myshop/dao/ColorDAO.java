package com.myshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.entity.Color;

@Repository(value = "colorDAO")
@Transactional(rollbackFor = Exception.class)
public class ColorDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean save(final Color color) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(color);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public boolean update(final Color color) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.merge(color);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public boolean delete(final Color color) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.delete(color);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public List<Color> getAll(){
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Color", Color.class).getResultList();
	}
	
	public Color findById(int colorId) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Color.class, colorId);
	}
}
