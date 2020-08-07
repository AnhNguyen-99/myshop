package com.myshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.entity.Producer;

@Repository(value = "producerDAO")
@Transactional(rollbackFor = Exception.class)
public class ProducerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean save(final Producer producer) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(producer);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public boolean update(final Producer producer) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.merge(producer);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public boolean delete(final Producer producer) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.delete(producer);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public List<Producer> getAll(){
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Producer", Producer.class).getResultList();
	}
	
	public Producer findById(int producerId) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Producer.class, producerId);
	}
	
}
