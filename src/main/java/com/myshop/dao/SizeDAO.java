package com.myshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.entity.Sizes;


@Repository(value = "sizeDAO")
@Transactional(rollbackFor = Exception.class)
public class SizeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean save(final Sizes sizes) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(sizes);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public boolean update(final Sizes sizes) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.merge(sizes);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public boolean delete(final Sizes sizes) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.delete(sizes);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public List<Sizes> getAll(){
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Sizes", Sizes.class).getResultList();
	}
	
	public Sizes findById(int sizeId) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Sizes.class, sizeId);
	}
}
